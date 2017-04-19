package org.ch3.joinTest1;

public class Test
{
	public static void main(String[] args)
	{
		try
		{
			MyThread threadTest = new MyThread();
			threadTest.start();
			threadTest.join(5000);
			System.out.println("now i can sure to execute after threadTest");
			//			Thread.sleep(?)
			//			System.out.println("i want to execute after threadTest");
			//			System.out.println("but what is the value of the sleep above?");
			//			System.out.println("the answer is: i do not sure");
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}

class MyThread extends Thread
{
	@Override
	public void run()
	{
		try
		{
			int secondValue = (int) (Math.random() * 10000);
			System.out.println(secondValue);
			Thread.sleep(secondValue);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}