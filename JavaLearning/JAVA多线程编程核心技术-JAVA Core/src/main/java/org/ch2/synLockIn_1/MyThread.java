package org.ch2.synLockIn_1;

public class MyThread extends Thread
{
	public void run()
	{
		Service service = new Service();
		service.service1();
	}
}
