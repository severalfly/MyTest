package org.leon.thread.t11;

import org.leon.thread.Mythread;

public class MyThreadInterrupt extends Thread
{
	public void run()
	{
		super.run();
		for (int i = 0; i < 5; i++)
		{
			System.out.println("i= " + (i + 1));
		}
	}

	public static class Run
	{
		public static void main(String[] args)
		{
			try
			{
				Mythread thread = new Mythread();
				thread.start();
				Thread.sleep(2000);
				thread.interrupt();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

}