package org.ch2.stringAndSyn;

public class Service
{
	public static void print(String stringParam)
	{
		try
		{
			synchronized (stringParam)
			{
				while (true)
				{
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(1000);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
