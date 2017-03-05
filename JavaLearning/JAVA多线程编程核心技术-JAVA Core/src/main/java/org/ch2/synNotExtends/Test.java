package org.ch2.synNotExtends;

public class Test
{
	/**
	 * 此包说明同步不具有继承性
	 * @param args
	 */
	public static void main(String[] args)
	{
		Sub subRef = new Sub();
		MyThreadA a = new MyThreadA(subRef);
		a.setName("A");
		a.start();
		MyThreadB b = new MyThreadB(subRef);
		b.setName("B");
		b.start();
	}
}
