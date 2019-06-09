package org.ch3.stack_2_old;

import java.util.ArrayList;
import java.util.List;

public class MyStack
{
	private List<Object> list = new ArrayList<Object>();

	synchronized public void push()
	{
		try
		{
			while (list.size() == 1)
			{
				this.wait();
			}
			list.add("anyString = " + Math.random());
			this.notifyAll();
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
			while (list.size() == 0)
			{
				System.out.println("pop operator: " + Thread.currentThread().getName() + " is waiting");
				this.wait();
			}
			returnValue = "" + list.size();
			list.remove(0);
			this.notifyAll();
			System.out.println("pop = " + list.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return returnValue;
	}
}
