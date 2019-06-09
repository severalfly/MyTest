package com.leon.wechart.schedule.test;

import java.util.Date;

public class TestThreadLocalWorker extends Thread
{
	//	public ThreadLocal<String> th = new ThreadLocal<String>();
	public String th = null;

	@Override
	public void run()
	{
		//		System.out.println(th.get());
		//		th.set("aa" + new Date());
		System.out.println(th);
		th = "" + new Date();
		System.out.println(th);
	}

	public static long firstDelay()
	{
		return 0;
	}
}
