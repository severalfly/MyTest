<<<<<<< HEAD
package org.ch2.t1;

public class ThreadB extends Thread
{
	private HasSelfPrivateNum numRef;

	public ThreadB(HasSelfPrivateNum numRef)
	{
		super();
		this.numRef = numRef;
	}

	public void run()
	{
		super.run();
		numRef.addI("b");
	}
}
=======
package org.ch2.t1;

public class ThreadB extends Thread
{
	private HasSelfPrivateNum numRef;

	public ThreadB(HasSelfPrivateNum numRef)
	{
		super();
		this.numRef = numRef;
	}

	public void run()
	{
		super.run();
		numRef.addI("b");
	}
}
>>>>>>> dd36be3a48a0e43b39b0327bc1b4cdb412b1d5bb
