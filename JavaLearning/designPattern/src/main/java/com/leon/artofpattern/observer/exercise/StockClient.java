package com.leon.artofpattern.observer.exercise;

import java.util.Observable;

public class StockClient
{
	public static void main(String[] args)
	{
		StockMan m = new StockMan("first");
		StockMan m2 = new StockMan("second");

		Observable soft = new StockSoft();

		soft.addObserver(m);
		soft.addObserver(m2);

		//		man.notifyObservers("5%");
		m.update(soft, null);
	}
}
