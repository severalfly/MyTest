package org.ch2.synBlockString;

public class BThread extends Thread
{
	private Service service;

	public BThread(Service service)
	{
		super();
		this.service = service;
	}

	@Override
	public void run()
	{
		this.service.setUsernamePassword("b", "bb");
	}

}
