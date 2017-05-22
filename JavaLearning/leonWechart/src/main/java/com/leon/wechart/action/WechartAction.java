package com.leon.wechart.action;

import java.sql.Time;
import java.util.Map;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.leon.wechart.AbstractAction;
import com.leon.wechart.service.WeChartService;
import com.leon.wechart.service.WeatherService;
import com.leon.wechart.util.EncryptUtil;
import com.leon.wechart.util.HttpServletRequestUtil;
import com.leon.wechart.util.LeonHttpClient;
import com.leon.wechart.util.ObjectUtil;

public class WechartAction extends AbstractAction
{
	private static final long serialVersionUID = -9050109194783103434L;
	private static Logger logger = Logger.getLogger(WechartAction.class);
	private String city;
	private String signature;
	private String timestamp;
	private String nonce;
	private String echostr;

	@Action(value = "/wechart")
	public void wechart()
	{
		try
		{
			System.out.println("leon" + new Time(System.currentTimeMillis()));
			TreeSet<String> set = new TreeSet<>();
			set.add("leon");
			set.add(this.timestamp);
			set.add(this.nonce);
			String msg = "";
			for (String str : set)
			{
				msg += str;
			}
			if (this.signature.equalsIgnoreCase(EncryptUtil.encodeSHA(msg)))
			{
				String result = this.echostr;
				String param = HttpServletRequestUtil.getParamFromRequestStream();
				if (ObjectUtil.isNotNull(param))
				{
					Map<String, Object> s = WeChartService.parseXmlToList2(param);
				}
				outputString(result);
			}
		}
		catch (Exception e)
		{
			logger.error(e);
		}
		outputString("");
	}

	@Action(value = "/weather/queryWeather")
	public void queryWeather()
	{
		logger.info(ServletActionContext.getRequest().getParameterMap());
		String str = WeatherService.getWeather(this.city);
		JSONObject json = JSONObject.parseObject(str);
		JSONObject result = json.getJSONObject("result");
		JSONObject realtime = result.getJSONObject("realtime");// 实时来天气
		JSONObject weather = realtime.getJSONObject("weather");
		//		 "humidity": "79",
		//         "img": "1",
		//         "info": "多云",
		//         "temperature": "23"
		StringBuffer res = new StringBuffer();
		res.append("天气：" + weather.getString("info") + "\n");
		res.append("相对湿度：" + weather.getString("humidity") + "%\n");
		res.append("温度：" + weather.getString("temperature") + "\n");
		//		res.append("温度：" + weather.getString("temperature") + "\n");
		//		WeatherService.getWeather(city);
		outputString(res.toString());
	}

	@Test
	public void testqueryWeather() throws Exception
	{
		String url = "http://127.0.0.1:8080/leonWechart/weather/queryWeather.action?city=武汉";
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
