package org.ch3.join_sleep_1;

public class Runn
{
	public static void main(String[] args)
	{
		try
		{
			ThreadB b = new ThreadB();
			ThreadA a = new ThreadA(b);
			a.start();
			Thread.sleep(1000);
			ThreadC c = new ThreadC(b);
			c.start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

class ThreadA extends Thread
{
	private ThreadB b;

	public ThreadA(ThreadB b)
	{
		super();
		this.b = b;
	}

	@Override
	public void run()
	{
		try
		{
			synchronized (this.b)
			{
				b.start();
				Thread.sleep(6000);

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

class ThreadB extends Thread
{
	@Override
	public void run()
	{
		try
		{
			System.out.println(" b run begin time=" + System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println(" b run end time = " + System.currentTimeMillis());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	synchronized public void bService()
	{
		System.out.println("bService time=" + System.currentTimeMillis());
	}
}

class ThreadC extends Thread
{
	private ThreadB b;

	public ThreadC(ThreadB b)
	{
		super();
		this.b = b;
	}

	@Override
	public void run()
	{
		b.bService();
	}
}