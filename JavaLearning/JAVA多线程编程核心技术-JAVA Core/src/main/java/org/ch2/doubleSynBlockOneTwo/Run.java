package org.ch2.doubleSynBlockOneTwo;

public class Run
{
	public static void main(String[] args)
	{
		ObjectService service = new ObjectService();
		AThread a = new AThread(service);
		a.setName("a");
		a.start();

		BThread b = new BThread(service);
		b.setName("b");
		b.start();
	}
}
