package com.leon.wechart.image;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSONObject;
import com.leon.wechart.util.LeonHttpClient;

public class Image
{
	static String url = "http://cc.postcc.us/htm_data/7/1711/%s.html";
	static List<String> list = new LinkedList<String>();
	private static ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(1000));

	public static void main(String[] args) throws Exception
	{
		//		LeonHttpClient client = new LeonHttpClient();
		int cnt = 10000;
		int start = 2750000;
		for (int i = start; i < start + cnt; i++)
		{
			submit(new ImageThread(i));
		}
		while (executor.getActiveCount() > 0 || executor.getQueue().size() > 0)
		{
			Thread.sleep(100);
		}
		System.out.println(JSONObject.toJSONString(list));
	}

	private static void submit(ImageThread th)
	{
		while (true)
		{
			try
			{
				executor.submit(th);
				break;
			}
			catch (Exception e)
			{
				continue;
			}
		}
	}
}

class ImageThread extends Thread
{
	private int id;

	public ImageThread(int id)
	{
		super();
		this.id = id;
	}

	@Override
	public void run()
	{
		try
		{
			String s = LeonHttpClient.sendRequestUrl(String.format(Image.url, this.id), null);
			if (s.contains("404"))
			{
				return;
			}
		}
		catch (Exception e)
		{
			return;
		}
		Image.list.add(this.id + "");
		if (Image.list.size() % 5 == 0)
		{
			System.out.println(Image.list.size());
		}
	}
}
