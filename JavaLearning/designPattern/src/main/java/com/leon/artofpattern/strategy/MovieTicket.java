package com.leon.artofpattern.strategy;

/**
 * 环境角色
 * @author leon
 *
 */
public class MovieTicket
{
	private double price;
	private Discount discount;

	public double getPrice()
	{
		return this.price;
	}

	public void setPrice(double price)
	{
		this.price = this.discount.calculate(price);
	}

	public Discount getDiscount()
	{
		return this.discount;
	}

	public void setDiscount(Discount discount)
	{
		this.discount = discount;
	}

}
