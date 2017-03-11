package org.ch2.stringAndSyn;

public class Run
{
	public static void main(String[] args)
	{
		Service serivce = new Service();
		AThread a = new AThread(serivce);
		a.setName("A");
		a.start();

		BThread b = new BThread(serivce);
		b.setName("B");
		b.start();
	}

}
