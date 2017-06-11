package com.leon.artofpattern.observer;

public class Player implements Observer
{
	private String name;

	public Player(String name)
	{
		this.name = name;
	}

	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public void help()
	{
		System.out.println("hold no: " + this.name + " coming to help u");
	}

	@Override
	public void beAttacked(AllyControlCenter acc)
	{
		System.out.println(this.name + " be attacked ");
		acc.notifyObserver(this.name);
	}

}
