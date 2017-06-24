package com.leon.artofpattern.strategy.execrise;

public class HarrierPlane extends Plane
{

	@Override
	public void takeOffCha()
	{
		System.out.println("vertical take off");
	}

	@Override
	public void flyCha()
	{
		System.out.println("super sonic fly");
	}

}
