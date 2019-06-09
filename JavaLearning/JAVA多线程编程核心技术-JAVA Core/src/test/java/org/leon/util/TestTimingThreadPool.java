package org.leon.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class TestTimingThreadPool
{
	private static TimingThreadPool threadExecutor = new TimingThreadPool(3, 5, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(100));

	public static void main(String[] args)
	{
		threadExecutor.submit(new DoTest());
	}
}

class DoTest extends Thread
{
	@Override
	public void run()
	{
		System.out.println(System.currentTimeMillis());
		try
		{
			Thread.sleep(1000l);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis());

	}
}
