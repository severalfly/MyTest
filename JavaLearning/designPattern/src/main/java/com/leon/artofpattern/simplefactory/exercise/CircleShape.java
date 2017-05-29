package com.leon.artofpattern.simplefactory.exercise;

public class CircleShape implements Shape
{

	@Override
	public void draw()
	{
		System.out.println("draw circle");
	}

	@Override
	public void erase()
	{
		System.out.println("erase circle");
	}

}
