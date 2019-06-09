package com.leon.templateMethod;

public abstract class PaPerTest
{
	public void question1()
	{
		System.out.println("questionA");
		System.out.println("答案" + answer1());
	}

	public void question2()
	{
		System.out.println("questionB");
		System.out.println("答案" + answer2());
	}

	abstract public String answer1();

	abstract public String answer2();
}
