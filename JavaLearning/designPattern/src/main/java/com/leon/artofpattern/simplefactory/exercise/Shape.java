package com.leon.artofpattern.simplefactory.exercise;

public abstract class Shape
{
	public abstract void draw();

	public abstract void erase();

	public static Shape getShape(String type)
	{
		Shape shape = null;
		switch (type)
		{
		case "circle":
			shape = new CircleShape();
			break;
		case "rectangle":
			shape = new RectangleShape();
			break;
		case "triangle":
			shape = new TriangleShape();
			break;
		default:
			break;
		}
		return shape;
	}
}
