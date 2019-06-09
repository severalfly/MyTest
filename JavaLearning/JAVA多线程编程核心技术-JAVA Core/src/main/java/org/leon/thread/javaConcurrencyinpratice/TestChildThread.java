package org.leon.thread.javaConcurrencyinpratice;

import java.util.ArrayList;
import java.util.List;

public class TestChildThread
{
	public static ThreadLocal<List<String>> exporting = new ThreadLocal<List<String>>();
	static
	{
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++)
		{
			list.add("" + i);
		}
		exporting.set(list);
	}

	public static void main(String[] args)
	{
		//		for
	}
}

class ThreadTest extends Thread
{
	private int i;

	public ThreadTest(int i)
	{
		this.i = i;
	}

	@Override
	public void run()
	{
		System.out.println(this.i);
	}
}
