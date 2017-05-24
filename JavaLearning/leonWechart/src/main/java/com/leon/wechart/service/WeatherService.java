package com.leon.wechart.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leon.wechart.action.WechartAction;
import com.leon.wechart.util.LeonHttpClient;

public class WeatherService
{
	private static Logger logger = LoggerFactory.getLogger(WechartAction.class);
	public static String getWeather(String city)
	{
		try
		{
			String url = "http://api.avatardata.cn/Weather/Query?key=d0a5d233555942818f14f34698ec7899&cityname=" + city;
			String data = LeonHttpClient.sendRequestUrl(url, null);
			logger.info(data);
			return data;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "";
	}

	public static void main(String[] args)
	{
		System.out.println(getWeather("武汉"));
	}
}
