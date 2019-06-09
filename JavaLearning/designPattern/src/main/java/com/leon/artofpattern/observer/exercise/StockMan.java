package com.leon.artofpattern.observer.exercise;

import java.util.Observable;
import java.util.Observer;

public class StockMan implements Observer
{
	private String name;

	public StockMan(String name)
	{
		super();
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg)
	{
		System.out.println("市值变化超过" + arg + "了" + this.name);
		o.notifyObservers();
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
