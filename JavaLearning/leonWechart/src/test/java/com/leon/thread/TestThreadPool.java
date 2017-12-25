package com.leon.thread;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试线程池
 * @author megan
 *
 */
public class TestThreadPool
{
	private static ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 10, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(1000));
	public static void main(String[] args)
	{
		for (int i = 0; i < 100; i++)
		{
			executor.submit(new TP());
			System.out.println(executor.getActiveCount());
		}
	}
}

class TP extends Thread
{
	@Override
	public void run()
	{
		System.out.println(new Date());
	}
}
