package com.leon.artofpattern.strategy;

public class ChildrenDiscount extends Discount
{

	@Override
	public double calculate(double price)
	{
		System.out.println("children ticket");
		return price - 10;
	}

}
