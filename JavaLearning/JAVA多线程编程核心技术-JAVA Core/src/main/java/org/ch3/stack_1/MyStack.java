package org.ch3.stack_1;

import java.util.ArrayList;
import java.util.List;

public class MyStack
{
	private List<Object> list = new ArrayList<Object>();

	synchronized public void push()
	{
		try
		{
			if (list.size() == 1)
			{
				this.wait();
			}
			list.add("anyString = " + Math.random());
			this.notify();
			System.out.println("push = " + list.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	synchronized public String pop()
	{
		String returnValue = "";
		try
		{
			if (list.size() == 0)
			{
				System.out.println("pop operator: " + Thread.currentThread().getName() + " is waiting");
				this.wait();
			}
			returnValue = "" + list.size();
			list.remove(0);
			this.notify();
			System.out.println("pop = " + list.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return returnValue;
	}
}
