package org.leon.thread;

public class Test
{
	public static void main(String[] args)
	{
		try
		{
			Mythread thread = new Mythread();
			thread.setName("mythread");
			thread.start();
			for (int i = 0; i < 10; i++)
			{
				int time = (int) (Math.random() * 1000);
				Thread.sleep(time);
				System.out.println("main=" + Thread.currentThread().getName());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
