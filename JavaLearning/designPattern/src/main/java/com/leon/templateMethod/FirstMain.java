package com.leon.templateMethod;

public class FirstMain
{
	public static void main(String[] args)
	{
		PaPerA a = new PaPerA();
		a.testA();
		a.testB();

		PaPerB b = new PaPerB();
		b.testA();
		b.testB();
	}
}

class PaPerA
{
	public void testA()
	{
		System.out.println("TestA");
		System.out.println("answer 0");
	}

	public void testB()
	{
		System.out.println("testB");
		System.out.println("answer 1");
	}
}

class PaPerB
{
	public void testA()
	{
		System.out.println("TestA");
		System.out.println("answer 0");
	}

	public void testB()
	{
		System.out.println("testB");
		System.out.println("answer 1");
	}
}
