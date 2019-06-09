package org.ch3.ch31;

public class Run
{
	public static void main(String[] args)
	{

		MyList service = new MyList();
		AThread a = new AThread(service);
		a.setName("a");
		a.start();

		BThread b = new BThread(service);
		b.setName("b");
		b.start();
	}
}
