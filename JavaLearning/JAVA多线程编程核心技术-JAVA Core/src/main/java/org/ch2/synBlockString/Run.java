package org.ch2.synBlockString;

public class Run
{
	public static void main(String[] args)
	{
		Service service = new Service();
		AThread a = new AThread(service);
		a.setName("A");
		a.start();
		BThread b = new BThread(service);
		b.setName("B");
		b.start();
	}
}
