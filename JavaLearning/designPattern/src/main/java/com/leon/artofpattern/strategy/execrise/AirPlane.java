package com.leon.artofpattern.strategy.execrise;

public class AirPlane extends Plane
{

	@Override
	public void takeOffCha()
	{
		System.out.println("long distance take off");
	}

	@Override
	public void flyCha()
	{
		System.out.println("sub scoinc fly");
	}

}
