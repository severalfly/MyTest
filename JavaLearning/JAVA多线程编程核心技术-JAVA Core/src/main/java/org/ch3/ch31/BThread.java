package org.ch3.ch31;

public class BThread extends Thread
{
	private MyList list;

	public BThread(MyList list)
	{
		this.list = list;
	}

	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				if (this.list.size() >= 5)
				{
					System.out.println("==5, thread b will stop");
					break;
				}
			}
			System.out.println("success break;");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}