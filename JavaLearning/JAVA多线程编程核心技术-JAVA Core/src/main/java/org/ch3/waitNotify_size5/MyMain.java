package org.ch3.waitNotify_size5;

import java.util.ArrayList;
import java.util.List;

public class MyMain
{
	public static void main(String[] args)
	{
		try
		{
			Object lock = new Object();
			ThreadA a = new ThreadA(lock);
			a.start();
			Thread.sleep(50);
			ThreadB b = new ThreadB(lock);
			b.start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

class MyList
{
	private static List<Object> list = new ArrayList<Object>();

	public static void add()
	{
		list.add("leon");
	}

	public static int size()
	{
		return list.size();
	}
}

class ThreadA extends Thread
{
	private Object lock;

	public ThreadA(Object lock)
	{
		super();
		this.lock = lock;
	}

	@Override
	public void run()
	{
		try
		{
			synchronized (lock)
			{
				if(MyList.size() != 5)
				{
					System.out.println("wait begin " + System.currentTimeMillis());
					lock.wait();
					System.out.println("wait end " + System.currentTimeMillis());

				}
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
	private Object lock;

	public ThreadB(Object lock)
	{
		super();
		this.lock = lock;
	}

	public void run()
	{
		try
		{
			synchronized (lock)
			{
				for (int i = 0; i < 10; i++)
				{
					MyList.add();
					if (MyList.size() == 5)
					{
						lock.notify();
						System.out.println("have notified");
					}
					System.out.println(" add " + (i + 1) + " elements");
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