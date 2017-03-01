package org.ch2.towObjectTwoLock;

public class ThreadB extends Thread
{
	private HasSelfPrivateNum numRef;

	public ThreadB(HasSelfPrivateNum numRef)
	{
		this.numRef = numRef;
	}

	public void run()
	{
		super.run();
		numRef.addI("b");
	}
}