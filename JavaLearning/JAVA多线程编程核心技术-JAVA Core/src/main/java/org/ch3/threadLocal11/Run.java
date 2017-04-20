package org.ch3.threadLocal11;

public class Run
{
	public static ThreadLocal t1 = new ThreadLocal();

	public static void main(String[] args)
	{
		if (t1.get() == null)
		{
			System.out.println("never add anything");
			t1.set("my value");
		}
		System.out.println(t1.get());
		System.out.println(t1.get());
	}

}
