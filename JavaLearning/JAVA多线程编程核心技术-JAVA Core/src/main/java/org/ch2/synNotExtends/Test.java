package org.ch2.synNotExtends;

public class Test
{
	/**
	 * �˰�˵��ͬ�������м̳���
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
