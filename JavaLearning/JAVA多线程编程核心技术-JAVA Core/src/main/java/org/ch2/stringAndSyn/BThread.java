package org.ch2.stringAndSyn;

public class BThread extends Thread
{
	private Service service;

	public BThread(Service service)
	{
		this.service = service;
	}

	@Override
	public void run()
	{
		this.service.print("AA");
	}
}
