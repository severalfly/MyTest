package com.leon.wechart.service;

import java.io.IOException;

import org.apache.http.ParseException;
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
		CloseableHttpClient client = HttpClients.createDefault();
		//		http://dynamic.12306.cn/mapping/kfxt/zwdcx/LCZWD/from2.jsp?cz=%BA%BA%BF%DA&cc=T180&cxlx=1&rq=2017-05-17&czEn=-E6-B1-89-E5-8F-
		HttpGet get = new HttpGet("http://dynamic.12306.cn/mapping/kfxt/zwdcx/LCZWD/from2.jsp?cz=%BA%BA%BF%DA&cc=T180&cxlx=1&rq=2017-05-17&czEn=-E6-B1-89-E5-8F-");
		CloseableHttpResponse s = null;
		try
		{
			//			get.setHeader("Connection:keep", "keep-alive");
			//			get.setHeader("Content-Encoding", "gzip");
			//			get.setHeader("Content-Type", "text/html; charset=gb2312");
			//			get.setHeader("Accept", "*/*");
			//			get.setHeader("Accept-Encoding", "gzip, deflate, sdch");
			//			get.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
			//			get.setHeader("Host", "dynamic.12306.cn");
			//			get.setHeader("Referer", "http://dynamic.12306.cn/mapping/kfxt/zwdcx/LCZWD/CCCX.jsp");
			//			get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.75 Safari/537.36");
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
			try
			{
				System.out.println(s.getEntity().getContent());
				return new String(EntityUtils.toString(s.getEntity()).getBytes("GBK"), "UTF-8");
			}
			catch (ParseException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			return null;
		}
	}

	public static void main(String[] args)
	{
		System.out.println(getWeather("武汉"));
	}
}
