package com.leon.artofpattern.strategy.execrise;

public class HelicopterPlane extends Plane
{

	@Override
	public void takeOffCha()
	{
		System.out.println("vertical take off");
	}

	@Override
	public void flyCha()
	{
		System.out.println("subsonic fly");
	}

}
