package org.ch3.p_r_allwait;

public class ThreadC extends Thread
{
	private C c;

	public ThreadC(C c)
	{
		super();
		this.c = c;
	}

	@Override
	public void run()
	{
		while (true)
		{
			c.getValue();
		}
	}

}
