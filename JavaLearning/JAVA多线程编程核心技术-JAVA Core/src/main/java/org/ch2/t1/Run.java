<<<<<<< HEAD
package org.ch2.t1;

public class Run
{
	public static void main(String[] args)
	{
		HasSelfPrivateNum numRef = new HasSelfPrivateNum();
		ThreadA athread = new ThreadA(numRef);
		athread.start();
		ThreadB bthread = new ThreadB(numRef);
		bthread.start();
	}
}
=======
package org.ch2.t1;

public class Run
{
	public static void main(String[] args)
	{
		HasSelfPrivateNum numRef = new HasSelfPrivateNum();
		ThreadA athread = new ThreadA(numRef);
		athread.start();
		ThreadB bthread = new ThreadB(numRef);
		bthread.start();
	}
}
>>>>>>> dd36be3a48a0e43b39b0327bc1b4cdb412b1d5bb
