package com.leon.proxy;

public class Pursuit implements GiveGift
{
	private SchoolGirl mm;

	public Pursuit(SchoolGirl mm)
	{
		super();
		this.mm = mm;
	}

	public void giveDolls()
	{
		System.out.println(this.mm.getName() + " give u a doll");
	}

	public void giveFlowers()
	{
		System.out.println(this.mm.getName() + " give u a flower");

	}

	public void giveChocolate()
	{
		System.out.println(this.mm.getName() + " give u a chocolate");

	}

}
