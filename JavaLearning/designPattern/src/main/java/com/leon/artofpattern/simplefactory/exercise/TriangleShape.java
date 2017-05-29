package com.leon.artofpattern.simplefactory.exercise;

public class TriangleShape extends Shape
{

	@Override
	public void draw()
	{
		System.out.println("draw triangle");
	}

	@Override
	public void erase()
	{
		System.out.println("erase triangle");
	}

}
