package org.ch2.t3;

public class ThreadA extends Thread
{
	private PublicVar publicVar;

	public ThreadA(PublicVar publicVar)
	{
		super();
		this.publicVar = publicVar;
	}

	public void run()
	{
		super.run();
		publicVar.setValue("B", "BB");
	}
}
