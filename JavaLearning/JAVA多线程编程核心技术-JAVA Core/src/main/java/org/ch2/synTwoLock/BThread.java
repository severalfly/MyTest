package org.ch2.synTwoLock;

public class BThread extends Thread
{
	private Service service;

	public BThread(Service serivce)
	{
		this.service = serivce;
	}

	@Override
	public void run()
	{
		this.service.printB();
	}
}
