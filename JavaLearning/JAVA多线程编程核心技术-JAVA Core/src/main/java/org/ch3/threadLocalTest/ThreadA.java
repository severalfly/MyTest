package org.ch3.threadLocalTest;

public class ThreadA extends Thread
{
	@Override
	public void run()
	{
		try
		{
			for (int i = 0; i < 10; i++)
			{
				Tools.t1.set("ThreadA " + (i + 1));
				System.out.println("ThreadA get value=" + Tools.t1.get());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
