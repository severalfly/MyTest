package com.leon.artofpattern.simplefactory.exercise;

public class ShapeFactory
{
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
