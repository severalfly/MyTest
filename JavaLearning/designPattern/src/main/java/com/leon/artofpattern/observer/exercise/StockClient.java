package com.leon.artofpattern.observer.exercise;

public class StockClient
{
	public static void main(String[] args)
	{
		StockMan m = new StockMan("first");
		StockMan m2 = new StockMan("second");

		StockSoft soft = new StockSoft();

		soft.addObserver(m);
		soft.addObserver(m2);

		soft.setStockIndex(2);

		soft.setStockIndex(4);
		soft.setStockIndex(4);
	}
}
