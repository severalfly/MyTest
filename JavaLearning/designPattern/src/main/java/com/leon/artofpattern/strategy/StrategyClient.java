package com.leon.artofpattern.strategy;

import com.leon.util.XMLUtil;

public class StrategyClient
{
	public static void main(String[] args)
	{
		Discount discount = (Discount) XMLUtil.getBean("strategy");
		MovieTicket ticket = new MovieTicket();
		ticket.setDiscount(discount);
		ticket.setPrice(60f);

		System.out.println("current price: " + ticket.getPrice());
	}
}
