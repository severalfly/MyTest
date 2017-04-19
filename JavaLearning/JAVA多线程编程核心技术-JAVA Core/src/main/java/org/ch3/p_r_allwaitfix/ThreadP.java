package org.ch3.p_r_allwaitfix;

public class ThreadP extends Thread
{
	private P p;

	public ThreadP(P p)
	{
		super();
		this.p = p;
	}

	@Override
	public void run()
	{
		while (true)
		{
			p.setValue();
		}
	}
}
