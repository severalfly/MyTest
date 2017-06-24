package com.leon.artofpattern.strategy;

public class StudentDescount extends Discount
{

	@Override
	public double calculate(double price)
	{
		System.out.println("student ticket");
		return price * 0.8;
	}

}
