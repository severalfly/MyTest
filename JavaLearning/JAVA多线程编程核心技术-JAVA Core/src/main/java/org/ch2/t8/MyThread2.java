package org.ch2.t8;

public class MyThread2 extends Thread
{
	private Task task;

	public MyThread2(Task task)
	{
		super();
		this.task = task;
	}

	@Override
	public void run()
	{
		super.run();
		this.task.otherMethod();
	}
}
