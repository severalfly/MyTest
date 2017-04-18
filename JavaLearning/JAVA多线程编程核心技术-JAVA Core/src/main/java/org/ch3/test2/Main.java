package org.ch3.test2;

public class Main extends Thread
{
	public static void main(String[] args)
	{
		try
		{
			Object lock = new Object();
			MyThread1 t1 = new MyThread1(lock);
			t1.start();

			Thread.sleep(3000);

			MyThread2 t2 = new MyThread2(lock);
			t2.start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

class MyThread1 extends Thread
{
	private Object lock;

	public MyThread1(Object lock)
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
				System.out.println("start wait time= " + System.currentTimeMillis());
				lock.wait();
				System.out.println("end wait time= " + System.currentTimeMillis());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
class MyThread2 extends Thread
{
	private Object lock;

	public MyThread2(Object lock)
	{
		this.lock = lock;
	}

	@Override
	public void run()
	{
		synchronized (lock)
		{
			System.out.println("start notifi time=" + System.currentTimeMillis());
			lock.notify();
			System.out.println("end notifi time=" + System.currentTimeMillis());
		}
	}
}

