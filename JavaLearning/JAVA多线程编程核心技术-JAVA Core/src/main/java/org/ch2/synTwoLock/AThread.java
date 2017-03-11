package org.ch2.synTwoLock;

public class AThread extends Thread
{
	private Service service;

	public AThread(Service serivce)
	{
		this.service = serivce;
	}

	@Override
	public void run()
	{
		this.service.printA();
	}
}
