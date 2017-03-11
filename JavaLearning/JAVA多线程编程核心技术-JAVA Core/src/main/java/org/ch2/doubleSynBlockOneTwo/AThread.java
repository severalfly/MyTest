package org.ch2.doubleSynBlockOneTwo;

public class AThread extends Thread
{
	private ObjectService service;

	public AThread(ObjectService service)
	{
		super();
		this.service = service;
	}

	@Override
	public void run()
	{
		super.run();
		service.serviceMethodA();
	}
}
