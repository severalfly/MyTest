package mythread;

public class Mythread extends Thread
{
	@Override
	public void run()
	{
		try
		{
			for (int i = 0; i < 10; i++)
			{
				int time = (int) (Math.random() * 1000);
				Thread.sleep(time);
				System.out.println("run=" + Thread.currentThread().getName());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
