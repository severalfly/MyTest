package org.ch3.stack_2_new;

public class C
{
	private MyStack stack;

	public C(MyStack stack)
	{
		super();
		this.stack = stack;
	}

	public void popService()
	{
		while (true)
		{
			System.out.println("pop=" + this.stack.pop());
		}
	}
}
