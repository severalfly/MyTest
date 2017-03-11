package org.ch2.doubleSynBlockOneTwo;

public class BThread extends Thread
{
	private ObjectService service;

	public BThread(ObjectService service)
	{
		super();
		this.service = service;
	}

	@Override
	public void run()
	{
		super.run();
		service.serviceMethodB();
	}
}
