package com.leon.wechart.service;

import java.util.Random;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
			logger.info("查询天气：" + url);
			String data = LeonHttpClient.sendRequestUrl(url, null);
			logger.info("查询天气结果" + data);
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

	/**
	 * 获取一定数量的笑话
	 * @param count
	 * @return
	 */
	public static String getLaugh(int count)
	{
		try
		{
			StringBuffer sb = new StringBuffer();
			int cnt = 1;
			String url = "http://api.avatardata.cn/Joke/QueryJokeByTime?key=892edfd091814b599ce931b53712811f&page=" + new Random().nextInt(100) + "&rows=" + count + "&sort=desc&time=" + System.currentTimeMillis() / 1000;
			String reqRes = LeonHttpClient.sendRequestUrl(url, null);
			logger.info(reqRes);
			JSONObject json = JSONObject.parseObject(reqRes);
			if (json.getIntValue("error_code") == 0)
			{
				// 返回正确结果
				JSONArray data = json.getJSONArray("result");
				for (Object object : data)
				{
					sb.append((cnt++) + ". ");
					sb.append(JSONObject.parseObject(object.toString()).get("content") + "\n");
				}
				return (sb.toString() + "\n").replace("\n\n", "");
			}
		}
		catch (Exception e)
		{
			logger.error("", e);
		}
		return null;
	}

	@Test
	public void testGetLaugh()
	{
		System.out.println(getLaugh(10));
	}

	public static String queryByTrain(String trainCode)
	{
		try
		{
			String url = "http://api.avatardata.cn/Train/QueryByTrain?key=e661c8f03b3b40bcb565f29059bcd7df&train=" + trainCode;
			String r = LeonHttpClient.sendRequestUrl(url, null);
			return r;
		}
		catch (Exception e)
		{
			logger.error("", e);
		}
		return "";
	}

	@Test
	public void testQueryByTrain()
	{
		System.out.println(queryByTrain("g9"));
	}
}
