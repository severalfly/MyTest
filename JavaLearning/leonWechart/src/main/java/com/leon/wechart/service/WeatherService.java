package com.leon.wechart.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class WeatherService
{
	public static String getWeather(String city)
	{
		try
		{
			CloseableHttpClient client = HttpClients.createDefault();
			HttpGet get = new HttpGet("http://api.avatardata.cn/Weather/Query?key=d0a5d233555942818f14f34698ec7899&cityname=" + city);
			CloseableHttpResponse s = null;
			try
			{
				s = client.execute(get);
			}
			catch (ClientProtocolException e)
			{
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			if (s == null)
			{
				return null;
			}
			else
			{
				return EntityUtils.toString(s.getEntity());
			}
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
