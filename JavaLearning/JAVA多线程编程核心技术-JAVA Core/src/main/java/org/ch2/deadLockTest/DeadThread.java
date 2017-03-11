package org.ch2.deadLockTest;

import org.junit.Test;

public class DeadThread implements Runnable
{
	public String username;
	public Object lock1 = new Object();
	public Object lock2 = new Object();

	public void setFlag(String username)
	{
		this.username = username;
	}

	public void run()
	{
		if (this.username.equals("a"))
		{
			// 先锁 lock1 
			synchronized (this.lock1)
			{
				try
				{
					System.out.println("username = " + this.username);
					Thread.sleep(3000);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			// 再锁 lock2
			synchronized (this.lock2)
			{
				System.out.println("按 lock1->lock2 代码顺序执行了");
			}
		}
		if (this.username.equals("b"))
		{
			// 先锁 lock2
			synchronized (this.lock2)
			{
				try
				{
					System.out.println("username = " + this.username);
					Thread.sleep(3000);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			// 再锁 lock1
			synchronized (this.lock1)
			{
				System.out.println("按 lock2->lock1 代码顺序执行了");
			}
		}
	}

	@Test
	public void testDeadLock()
	{
		try
		{
			DeadThread dt1 = new DeadThread();
			dt1.setFlag("a");
			Thread t1 = new Thread(dt1);
			t1.start();

			Thread.sleep(1000);

			DeadThread dt2 = new DeadThread();
			dt2.setFlag("b");
			Thread t2 = new Thread(dt2);
			t2.start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
