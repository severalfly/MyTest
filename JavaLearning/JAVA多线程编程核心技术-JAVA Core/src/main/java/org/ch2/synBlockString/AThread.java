package org.ch2.synBlockString;

public class AThread extends Thread
{
	private Service service;

	public AThread(Service service)
	{
		super();
		this.service = service;
	}

	@Override
	public void run()
	{
		service.setUsernamePassword("a", "aa");
	}

}
