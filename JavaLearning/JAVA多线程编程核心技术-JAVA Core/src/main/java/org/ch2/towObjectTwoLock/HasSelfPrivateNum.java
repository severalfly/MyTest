package org.ch2.towObjectTwoLock;

public class HasSelfPrivateNum
{
	private int num = 0;

	synchronized public void addI(String username)
	{
		try
		{
			if (username.equals("a"))
			{
				this.num = 100;
				System.out.println("a set over");
				Thread.sleep(2000);
			}
			else
			{
				this.num = 200;
				System.out.println("b set over");
			}
			System.out.println(username + " num = " + num);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
