package org.ch3.test1;

public class Test2
{
	public static void main(String[] args)
	{
		try
		{
			String lock = new String();
			System.out.println("syn 上面");
			synchronized (lock)
			{
				System.out.println("syn 第一行");
				lock.wait();
				System.out.println("wait 之后");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
