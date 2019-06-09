package com.leon.artofpattern.flyweight;

public class Coordinates
{
	private int x;
	private int y;

	public Coordinates(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString()
	{
		return "x = " + this.x + ", y = " + this.y;
	}

	public int getX()
	{
		return this.x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return this.y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

}
