package com.leon.facade;

public class Facade
{
	private SubSystem1 sub1;
	private SubSystem2 sub2;
	private SubSystem3 sub3;

	public Facade()
	{
		super();
		this.sub1 = new SubSystem1();
		this.sub2 = new SubSystem2();
		this.sub3 = new SubSystem3();
	}

	public void methodA()
	{
		System.out.println("第一组");
		sub1.method1();
		sub2.method2();
		sub3.method3();
	}

	public void methodB()
	{
		System.out.println("第二组");
		sub2.method2();
		sub3.method3();
	}

}
