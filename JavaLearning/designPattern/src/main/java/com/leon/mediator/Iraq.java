package com.leon.mediator;

public class Iraq extends Country
{

	public Iraq(UnitNations unitNations)
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
		System.out.println("Iraq获得消息" + msg);
	}

}
