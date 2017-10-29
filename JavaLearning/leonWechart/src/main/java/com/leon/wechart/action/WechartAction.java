package com.leon.wechart.action;

import java.util.Map;
import java.util.TreeSet;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.leon.wechart.AbstractAction;
import com.leon.wechart.bean.send.WxSendTextMsg;
import com.leon.wechart.service.WeChartService;
import com.leon.wechart.service.WeatherService;
import com.leon.wechart.service.ZwdService;
import com.leon.wechart.util.EncryptUtil;
import com.leon.wechart.util.HttpServletRequestUtil;
import com.leon.wechart.util.HttpUtil;
import com.leon.wechart.util.LeonHttpClient;
import com.leon.wechart.util.ObjectUtil;
import com.leon.wechart.util.Pair;
import com.leon.wechart.util.TrainUtil;

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
		logger.info(HttpUtil.getParam(ServletActionContext.getRequest().getParameterMap()));
		String result = "success";
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
			if (this.signature.equalsIgnoreCase(EncryptUtil.sha1(msg)))
			{
				result = this.echostr;
				String param = HttpServletRequestUtil.getParamFromRequestStream();
				logger.info("收到微信公众号发来消息: " + param);
				if (ObjectUtil.isNotNull(param))
				{
					Map<String, Object> s = WeChartService.parseXmlToList2(param);
					if ("text".equalsIgnoreCase(ObjectUtil.getString(s.get("MsgType"))))
					{
						String wxCon = ObjectUtil.getString(s.get("Content"));
						logger.info("获取到微信文字消息：" + wxCon);
						WxSendTextMsg wxMsg = new WxSendTextMsg(ObjectUtil.getString(s.get("FromUserName")), ObjectUtil.getString(s.get("ToUserName")), System.currentTimeMillis());
						String content = "";
						Pair<String, String> pair = TrainUtil.getTrainCodeStating(wxCon);
						logger.info("" + JSONObject.toJSONString(pair));
						if (pair != null)
						{
							//								String station = pair.right;
							content = ZwdService.queryZWDV2(pair.left, pair.right);
							//	http://dynamic.12306.cn/mapping/kfxt/zwdcx/LCZWD/cx.jsp?cz=%C9%CF%BA%A3%BA%E7%C7%C5&cc=g9&cxlx=0&rq=2017-10-18&czEn=-E4-B8-8A-E6-B5-B7-E8-99-B9-E6-A1-A5&tp=1508333945052
						}
						if (wxCon.startsWith("天气") || wxCon.endsWith("天气"))
						{
							String str = WeatherService.getWeather(wxCon.replace("天气", "").trim());
							if (ObjectUtil.isNotNull(str))
							{

								JSONObject json = JSONObject.parseObject(str);
								StringBuffer res = new StringBuffer("first");
								if (json != null)
								{
									JSONObject resultJson = json.getJSONObject("result");
									JSONObject realtime = resultJson.getJSONObject("realtime");// 实时来天气
									JSONObject weather = realtime.getJSONObject("weather");
									res = new StringBuffer();
									res.append("天气：" + weather.getString("info") + "\n");
									res.append("相对湿度：" + weather.getString("humidity") + "%\n");
									res.append("温度：" + weather.getString("temperature"));
									content = res.toString();
								}
							}
						}
						else if (wxCon.equals("笑话"))
						{
							content = WeatherService.getLaugh(5);
						}
						wxMsg.setContent(ObjectUtil.isNull(content) ? "您好" : content);
						result = WeChartService.getResult(wxMsg);
					}
					else if ("subscribe".equals(ObjectUtil.getString(s.get("MsgType"))))
					{
						WxSendTextMsg wxMsg = new WxSendTextMsg(ObjectUtil.getString(s.get("FromUserName")), ObjectUtil.getString(s.get("ToUserName")), System.currentTimeMillis());
						wxMsg.setContent("您好，欢迎关注，输入车次号查询火车正晚点信息，如    G9 上海虹桥");
						result = WeChartService.getResult(wxMsg);
					}
				}
				//				outputString(result);
			}
			logger.info("返回微信数据" + result);
		}
		catch (Exception e)
		{
			logger.error("", e);
		}
		outputString(result);
	}

	/**
	 * 返回是否是查询正晚点
	 * @param msg
	 * @return null 不符合正晚点输入格式；<车次号,车站>
	 */
	private Pair<String, String> checkZWDQuery(String msg)
	{
		if (ObjectUtil.isNull(msg) || ObjectUtil.isNull(msg.trim()))
		{
			return null;
		}
		if (msg.indexOf(" ") < 0)
		{
			logger.info("校验不含空格" + msg);
			return null;
		}
		String[] tmp = msg.split(" ");
		if (TrainUtil.isTrainCode(tmp[0]))
		{
			return new Pair<String, String>(tmp[0], tmp[1]);
		}
		else
		{
			logger.info("空格前不是车次号");
			return null;
		}

	}

	@Action(value = "/weather/queryWeather")
	public void queryWeather()
	{
		logger.info(HttpUtil.getParam(ServletActionContext.getRequest().getParameterMap()));
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

	//	@Test
	public void testqueryWeather() throws Exception
	{
		//		String url = "http://127.0.0.1:8080/leonWechart/weather/queryWeather.action?city=武汉";
		//		String url = "http://101.236.23.190:80/leonWechart/wechart.action?city=武汉";
		String url = "http://severalfly.6655.la/leonWechart/wechart.action?city=武汉";
		System.out.println(LeonHttpClient.sendRequestUrl(url, null));
	}

	public String getCity()
	{
		return this.city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getSignature()
	{
		return this.signature;
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
