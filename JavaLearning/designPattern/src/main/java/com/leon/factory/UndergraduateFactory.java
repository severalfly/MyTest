package com.leon.factory;

public class UndergraduateFactory implements IFactory
{

	public LeiFeng createLeiFeng()
	{
		return new Undergraduate();
	}

}
