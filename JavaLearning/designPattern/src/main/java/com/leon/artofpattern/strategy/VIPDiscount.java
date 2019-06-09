package com.leon.artofpattern.strategy;

public class VIPDiscount extends Discount
{

	@Override
	public double calculate(double price)
	{
		System.out.println("vip ticket");
		return price * 0.5;
	}

}
