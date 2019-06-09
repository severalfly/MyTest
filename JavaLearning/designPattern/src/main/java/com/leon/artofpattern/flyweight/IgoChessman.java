package com.leon.artofpattern.flyweight;

public abstract class IgoChessman
{
	public abstract String getColor();

	public void display(Coordinates coord)
	{
		System.out.println("the color of igo: " + this.getColor() + ", location: " + coord);
	}
}
