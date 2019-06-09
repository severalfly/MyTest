package com.leon.mediator;

public class USA extends Country
{

	public USA(UnitNations unitNations)
	{
		super(unitNations);
	}

	@Override
	public void declare(String msg)
	{
		this.unitNations.sendMsg(msg, this);
	}

	@Override
	public void getmsg(String msg)
	{
		System.out.println("USA获得信息" + msg);
	}
}
