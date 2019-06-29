package com.leon.artofpatternv2.ch6abstractfactory;

public class SpringTextField implements TextField
{
	@Override
	public void display()
	{
		System.out.println(this.getClass().getSimpleName());
	}
}
