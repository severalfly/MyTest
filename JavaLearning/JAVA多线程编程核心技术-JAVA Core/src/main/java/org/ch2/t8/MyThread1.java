package org.ch2.t8;

public class MyThread1 extends Thread
{
	private Task task;

	public MyThread1(Task task)
	{
		super();
		this.task = task;
	}

	@Override
	public void run()
	{
		super.run();
		this.task.doLongTimeTask();
	}
}
