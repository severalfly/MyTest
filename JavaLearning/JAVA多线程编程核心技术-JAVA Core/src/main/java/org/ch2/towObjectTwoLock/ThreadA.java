package org.ch2.towObjectTwoLock;

public class ThreadA extends Thread
{
	private HasSelfPrivateNum numRef;

	public ThreadA(HasSelfPrivateNum numRef)
	{
		this.numRef = numRef;
	}

	public void run()
	{
		super.run();
		numRef.addI("a");
	}
}
