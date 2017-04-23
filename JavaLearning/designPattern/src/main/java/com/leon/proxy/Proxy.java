package com.leon.proxy;

public class Proxy implements GiveGift
{
	private Pursuit gg;

	public Proxy(SchoolGirl mm)
	{
		super();
		this.gg = new Pursuit(mm);
	}

	public void giveDolls()
	{
		gg.giveDolls();
	}

	public void giveFlowers()
	{
		this.gg.giveFlowers();
	}

	public void giveChocolate()
	{
		this.gg.giveChocolate();
	}

}
