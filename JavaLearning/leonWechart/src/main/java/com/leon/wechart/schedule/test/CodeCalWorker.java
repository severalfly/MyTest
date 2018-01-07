package com.leon.wechart.schedule.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leon.wechart.util.LeonHttpClient;

public class CodeCalWorker extends Thread
{
	private ThreadPoolExecutor threadExecutor = new ThreadPoolExecutor(1000, 1000, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(1000));
	String url = "http://cl.itbb.men/register.php?reginvcode=123456789&action=reginvcodeck";
	private static final Logger logger = LoggerFactory.getLogger(CodeCalWorker.class);

	@Override
	public void run()
	{
		for (long i = Long.MAX_VALUE; i > 0; i--)
		{
			submit(new CodeHandler(i));
			if (i % 1000 == 0)
			{
				//				System.out.println(i + " 完成");
				logger.info(i + " 完成");
			}
		}
		while (this.threadExecutor.getActiveCount() > 0 || this.threadExecutor.getQueue().size() > 0)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	public void checkCode(long i)
	{
		LeonHttpClient client = null;
		try
		{
			String code = Long.toString(i, 36);
			String paramsStr = "reginvcode=" + code + "&action=reginvcodeck";
			//		System.out.println(LeonHttpClient.sendRequestPostParamsStr(url, paramsStr, null));
			client = new LeonHttpClient();
			String data = client.executeGet(url + paramsStr);
			//			String data = LeonHttpClient.sendRequestUrl(url + paramsStr, null);
			String name = Thread.currentThread().getName();
			if (data.contains("'0'"))
			{

				System.out.println(name + "   " + code);
				logger.error(name + "  " + code + "    " + data);
			}
		}
		catch (Exception e)
		{
			//			e.printStackTrace();
		}
		finally
		{
			if (client != null)
			{
				client.close();
			}
		}
	}

	private void submit(CodeHandler h)
	{
		while (true)
		{
			try
			{
				this.threadExecutor.submit(h);
				break;
			}
			catch (Exception e)
			{
			}
		}
	}

	class CodeHandler extends Thread
	{
		private long i;

		public CodeHandler(long i)
		{
			this.i = i;
		}

		@Override
		public void run()
		{
			checkCode(this.i);
		}
	}
}