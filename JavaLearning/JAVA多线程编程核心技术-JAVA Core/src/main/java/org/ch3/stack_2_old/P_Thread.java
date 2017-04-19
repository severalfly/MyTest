package org.ch3.stack_2_old;

public class P_Thread extends Thread
{

	private P p;

	public P_Thread(P p)
	{
		super();
		this.p = p;
	}

	@Override
	public void run()
	{
		while (true)
		{
			this.p.pushService();
		}
	}
}
