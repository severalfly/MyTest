package com.leon.artofpattern.observer.exercise;

import java.util.Observable;

public class StockSoft extends Observable
{
	private int stockIndex;// 股票指数

	public int getStockIndex()
	{
		return this.stockIndex;
	}

	public void setStockIndex(int stockIndex)
	{
		if (this.stockIndex != stockIndex)
		{
			this.stockIndex = stockIndex;
			setChanged();
			notifyObservers(stockIndex);
		}
	}

}
