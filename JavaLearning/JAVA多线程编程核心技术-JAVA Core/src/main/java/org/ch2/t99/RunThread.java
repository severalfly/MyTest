package org.ch2.t99;

import org.junit.Test;

public class RunThread extends Thread
{
	private volatile boolean isRunning = true;

	public boolean isRunning()
	{
		return isRunning;
	}

	public void setRunning(boolean isRunning)
	{
		this.isRunning = isRunning;
	}

	@Override
	public void run()
	{
		System.out.println("进入 run 了");
		while (this.isRunning)
		{
		}
		System.out.println("线程被停止了");
	}

	@Test
	public void test()
	{
		try
		{
			RunThread thread = new RunThread();
			thread.start();
			Thread.sleep(1000);
			thread.setRunning(false);
			System.out.println("已经被赋值为false");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * isRunning 被赋值时，会被存入公共堆栈与线程的私有堆栈中，普通模式下
	 * 即无 volatile 关键字时，在running 或者被优化时，虽然thread.setRunning(false) 被执行
	 * 但是公共堆栈的isRunning 还是true,也就造成了死循环
	 */

	public static void main(String[] args)
	{
		System.out.println("haha 2017-03-14");
	}
}
