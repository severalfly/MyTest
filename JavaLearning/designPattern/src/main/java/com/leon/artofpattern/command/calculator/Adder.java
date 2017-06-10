package com.leon.artofpattern.command.calculator;

public class Adder
{
	private int num = 0;

	public int add(int value)
	{
		this.num += value;
		return this.num;
	}
}
