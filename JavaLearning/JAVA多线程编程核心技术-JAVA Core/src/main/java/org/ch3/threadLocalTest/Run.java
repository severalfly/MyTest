package org.ch3.threadLocalTest;

public class Run
{
	public static void main(String[] args)
	{
		try
		{
			ThreadA a = new ThreadA();
			ThreadB b = new ThreadB();
			a.start();
			b.start();

			for (int i = 0; i < 10; i++)
			{
				Tools.t1.set("Main" + (i + 1));
				System.out.println("Main get value=" + Tools.t1.get());
				Thread.sleep(200);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
