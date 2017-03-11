package org.ch2.synTwoLock;

public class CThread extends Thread
{
	private Service service;

	public CThread(Service serivce)
	{
		this.service = serivce;
	}

	@Override
	public void run()
	{
		this.service.printC();
	}
}
