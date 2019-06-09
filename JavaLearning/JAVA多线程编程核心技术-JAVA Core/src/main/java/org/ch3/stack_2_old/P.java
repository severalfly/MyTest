package org.ch3.stack_2_old;

public class P
{
	private MyStack stack;

	public P(MyStack stack)
	{
		super();
		this.stack = stack;
	}

	public void pushService()
	{
		while (true)
		{
			this.stack.push();
		}
	}
}
