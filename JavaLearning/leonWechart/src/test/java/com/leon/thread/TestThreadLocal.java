package com.leon.thread;

import java.util.Random;

public class TestThreadLocal
{
	public static void main(String[] args)
	{
		int cnt = 20;
		TTL[] ts = new TTL[cnt];
		for (int i = 0; i < cnt; i++)
		{
			ts[i] = new TTL();
			ts[i].setTl(new Random().nextInt(100));
			ts[i].start();
			System.out.println(ts[i].getTl());
		}

	}
}

class TTL extends Thread
{
	private static ThreadLocal<Integer> tl = new ThreadLocal<Integer>();

	@Override
	public void run()
	{
		tl.set(new Random().nextInt(10));
		System.out.println(Thread.currentThread() + " before: " + tl.get());
		try
		{
			Thread.sleep(100);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread() + " after: " + tl.get());
	}

	public void setTl(int i)
	{
		tl.set(i);
	}

	public Integer getTl()
	{
		return tl.get();
	}
}