package com.leon.artofpatternv2.ch6abstractfactory;

public class SummerTextField implements TextField
{

	@Override
	public void display()
	{
		System.out.println(this.getClass().getSimpleName());
	}
}
