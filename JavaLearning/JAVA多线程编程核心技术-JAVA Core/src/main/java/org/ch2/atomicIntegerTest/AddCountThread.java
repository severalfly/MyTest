package org.ch2.atomicIntegerTest;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class AddCountThread extends Thread
{
	private AtomicInteger count = new AtomicInteger(0);

	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			System.out.println(this.count.incrementAndGet());
		}
	}

	@Test
	public void test()
	{
		AddCountThread countService = new AddCountThread();
		Thread t1 = new Thread(countService);
		t1.start();
		Thread t2 = new Thread(countService);
		t2.start();
		Thread t3 = new Thread(countService);
		t3.start();
		Thread t4 = new Thread(countService);
		t4.start();
		Thread t5 = new Thread(countService);
		t5.start();
	}
}
