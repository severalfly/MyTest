<<<<<<< HEAD
package org.ch2.t1;

public class ThreadA extends Thread
{
	private HasSelfPrivateNum numRef;

	public ThreadA(HasSelfPrivateNum numRef)
	{
		super();
		this.numRef = numRef;
	}

	public void run()
	{
		super.run();
		numRef.addI("a");
	}
}
=======
package org.ch2.t1;

public class ThreadA extends Thread
{
	private HasSelfPrivateNum numRef;

	public ThreadA(HasSelfPrivateNum numRef)
	{
		super();
		this.numRef = numRef;
	}

	public void run()
	{
		super.run();
		numRef.addI("a");
	}
}
>>>>>>> dd36be3a48a0e43b39b0327bc1b4cdb412b1d5bb
