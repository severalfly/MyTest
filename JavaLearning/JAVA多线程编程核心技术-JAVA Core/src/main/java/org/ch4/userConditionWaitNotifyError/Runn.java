package org.ch4.userConditionWaitNotifyError;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runn
{
	public static void main(String[] args)
	{
		MyService service = new MyService();
		ThreadA a = new ThreadA(service);
		a.start();
	}
}

class MyService
{
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void await()
	{
		try
		{
			condition.await();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

class ThreadA extends Thread
{
	private MyService service;

	public ThreadA(MyService service)
	{
		super();
		this.service = service;
	}

	@Override
	public void run()
	{
		service.await();
	}
}
