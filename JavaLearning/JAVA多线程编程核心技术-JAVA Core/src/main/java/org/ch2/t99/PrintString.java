package org.ch2.t99;

import org.junit.Test;

public class PrintString
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

	@Test
	public void test()
	{
		PrintString service = new PrintString();
		service.printStringMethod();
		System.out.println("i want it stop, stopThread=" + Thread.currentThread().getName());
		service.setContinuePrint(false);
	}
}
