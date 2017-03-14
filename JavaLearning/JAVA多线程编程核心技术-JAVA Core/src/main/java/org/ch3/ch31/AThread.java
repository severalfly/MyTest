package org.ch3.ch31;

public class AThread extends Thread
{
	private MyList list;

	public AThread(MyList list)
	{
		this.list = list;
	}

	@Override
	public void run()
	{
		try
		{
			for (int i = 0; i < 10; i++)
			{
				this.list.add();
				System.out.println("have add " + (i + 1) + " times");
				Thread.sleep(1000);
			}
			System.out.println("thread = " + Thread.currentThread().getName() + " will stop");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}