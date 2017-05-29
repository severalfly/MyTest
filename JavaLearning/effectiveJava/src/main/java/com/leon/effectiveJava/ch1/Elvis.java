package com.leon.effectiveJava.ch1;

public enum Elvis
{
	INSTANCE;
	public void leavTheBuilding()
	{

	}

	public void init()
	{
		System.out.println("do init");
	}

	public static void main(String[] args)
	{
		Elvis.INSTANCE.init();
	}
}
