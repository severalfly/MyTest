package com.leon.mediator;

public abstract class Country
{
	protected UnitNations unitNations;

	public Country(UnitNations unitNations)
	{
		super();
		this.unitNations = unitNations;
	}

	public abstract void declare(String msg);

	public abstract void getmsg(String msg);
}
