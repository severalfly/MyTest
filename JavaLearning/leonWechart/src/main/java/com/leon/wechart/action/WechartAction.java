package com.leon.wechart.action;

import java.util.Map;
import java.util.TreeSet;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.leon.wechart.AbstractAction;
import com.leon.wechart.bean.send.WxSendTextMsg;
import com.leon.wechart.service.WeChartService;
import com.leon.wechart.service.WeatherService;
import com.leon.wechart.util.EncryptUtil;
import com.leon.wechart.util.HttpServletRequestUtil;
import com.leon.wechart.util.LeonHttpClient;
import com.leon.wechart.util.ObjectUtil;

public class WechartAction extends AbstractAction
{
	private static final long serialVersionUID = -9050109194783103434L;
	private static Logger logger = LoggerFactory.getLogger(WechartAction.class);
	private String city;
	private String signature;
	private String timestamp;
	private String nonce;
	private String echostr;

	@Action(value = "/wechart")
	public void wechart()
	{
		logger.info(ServletActionContext.getRequest().getParameterMap().toString());
		try
		{
			TreeSet<String> set = new TreeSet<>();
			set.add("leon");
			set.add(this.timestamp);
			set.add(this.nonce);
			String msg = "";
			for (String str : set)
			{
				msg += str;
			}
			String result = "success";
			if (this.signature.equalsIgnoreCase(EncryptUtil.sha1(msg)))
			{
				result = this.echostr;
				String param = HttpServletRequestUtil.getParamFromRequestStream();
				if (ObjectUtil.isNotNull(param))
				{
					Map<String, Object> s = WeChartService.parseXmlToList2(param);
					if ("text".equalsIgnoreCase(ObjectUtil.getString(s.get("MsgType"))))
					{
						WxSendTextMsg wxMsg = new WxSendTextMsg(ObjectUtil.getString(s.get("FromUserName")), ObjectUtil.getString(s.get("ToUserName")), System.currentTimeMillis());
						String content = "";
						if ("天气".equals(ObjectUtil.getString(s.get("Content"))))
						{
							String str = WeatherService.getWeather(this.city);
							JSONObject json = JSONObject.parseObject(str);
							//		 "humidity": "79",
							//         "img": "1",
							//         "info": "多云",
							//         "temperature": "23"
							StringBuffer res = new StringBuffer("first");
							if (json != null)
							{
								JSONObject resultJson = json.getJSONObject("result");
								JSONObject realtime = resultJson.getJSONObject("realtime");// 实时来天气
								JSONObject weather = realtime.getJSONObject("weather");
								res = new StringBuffer();
								res.append("天气：" + weather.getString("info") + "\n");
								res.append("相对湿度：" + weather.getString("humidity") + "%\n");
								res.append("温度：" + weather.getString("temperature") + "\n");
								res.append("温度：" + weather.getString("temperature") + "\n");
								content = res.toString();
							}
						}
						wxMsg.setContent(ObjectUtil.isNull(content) ? "您好" : content);
						result = WeChartService.getResult(wxMsg);
					}
					else if ("subsi".equals(ObjectUtil.getString(s.get("MsgType"))))
					{
						WxSendTextMsg wxMsg = new WxSendTextMsg(ObjectUtil.getString(s.get("FromUserName")), ObjectUtil.getString(s.get("ToUserName")), System.currentTimeMillis());
						wxMsg.setContent("您好，欢迎关注");
						result = WeChartService.getResult(wxMsg);
					}
				}
				//				outputString(result);
			}
			logger.info("返回微信数据" + result);
			outputString(result);
		}
		catch (Exception e)
		{
			logger.error("", e);
		}
	}

	@Action(value = "/weather/queryWeather")
	public void queryWeather()
	{
		logger.info(city, ServletActionContext.getRequest().getParameterMap());
		String str = WeatherService.getWeather(this.city);
		JSONObject json = JSONObject.parseObject(str);
		//		 "humidity": "79",
		//         "img": "1",
		//         "info": "多云",
		//         "temperature": "23"
		StringBuffer res = new StringBuffer("first");
		if (json != null)
		{
			JSONObject result = json.getJSONObject("result");
			JSONObject realtime = result.getJSONObject("realtime");// 实时来天气
			JSONObject weather = realtime.getJSONObject("weather");
			res = new StringBuffer();
			res.append("天气：" + weather.getString("info") + "\n");
			res.append("相对湿度：" + weather.getString("humidity") + "%\n");
			res.append("温度：" + weather.getString("temperature") + "\n");
			res.append("温度：" + weather.getString("temperature") + "\n");
		}
		//		WeatherService.getWeather(city);
		outputString(res.toString());
	}

	@Test
	public void testqueryWeather() throws Exception
	{
		//		String url = "http://127.0.0.1:8080/leonWechart/weather/queryWeather.action?city=武汉";
		//		String url = "http://101.236.23.190:80/leonWechart/wechart.action?city=武汉";
		String url = "http://severalfly.6655.la/leonWechart/wechart.action?city=武汉";
		System.out.println(LeonHttpClient.sendRequestUrl(url, null));
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getSignature()
	{
		return signature;
	}

	public void setSignature(String signature)
	{
		this.signature = signature;
	}

	public String getTimestamp()
	{
		return timestamp;
	}

	public void setTimestamp(String timestamp)
	{
		this.timestamp = timestamp;
	}

	public String getNonce()
	{
		return nonce;
	}

	public void setNonce(String nonce)
	{
		this.nonce = nonce;
	}

	public String getEchostr()
	{
		return echostr;
	}

	public void setEchostr(String echostr)
	{
		this.echostr = echostr;
	}

}
