package org.ch2.stringAndSyn2;

public class AThread extends Thread
{
	private Service service;

	public AThread(Service service)
	{
		this.service = service;
	}

	@Override
	public void run()
	{
		this.service.print(new Object());
	}
}
