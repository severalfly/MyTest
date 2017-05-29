package com.leon.artofpattern.simplefactory.exercise;

public class SimpleFactoryClient
{
	public static void main(String[] args)
	{
		Shape shape = ShapeFactory.getShape("circle1");
		if (shape == null)
		{
			System.out.println("UnSupportedShapeException---");
		}
		else
		{
			shape.draw();
			shape.erase();
		}
	}
}
