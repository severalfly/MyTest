package com.leon.artofpattern.simplefactory.exercise;

public class RectangleShape implements Shape
{

	@Override
	public void draw()
	{
		System.out.println("draw rectangle");
	}

	@Override
	public void erase()
	{
		System.out.println("erase rectangle");

	}

}
