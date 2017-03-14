package org.ch2.t99;

import org.junit.Test;

public class PrintStringV2 implements Runnable
{
	private boolean isContinuePrint = true;

	public boolean isContinuePrint()
	{
		return isContinuePrint;
	}

	public void setContinuePrint(boolean isContinuePrint)
	{
		this.isContinuePrint = isContinuePrint;
	}

	public void printStringMethod()
	{
		try
		{
			while (this.isContinuePrint)
			{
				System.out.println("run printStringMethod threadName =" + Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void run()
	{
		printStringMethod();

	}

	@Test
	public void test()
	{
		// 现在能正确停止了，因为目前是两个线程，注意与PrintString的区别
		PrintStringV2 service = new PrintStringV2();
		new Thread(service).start();;
		System.out.println("i want it stop, stopThread=" + Thread.currentThread().getName());
		service.setContinuePrint(false);
	}

}
