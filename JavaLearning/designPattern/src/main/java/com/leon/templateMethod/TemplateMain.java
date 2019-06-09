package com.leon.templateMethod;

public class TemplateMain
{

	public static void main(String[] args)
	{
		PaPerTest a = new PaPerTestA();
		a.question1();
		a.question2();
		PaPerTest b = new PaperTestB();
		b.question1();
		b.question2();
	}

}
