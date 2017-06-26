package com.leon.artofpattern.flyweight.exercise;

public class Location
{
	private int x;
	private int y;
	private int size;

	@Override
	public String toString()
	{
		return "Location [x=" + x + ", y=" + y + ", size=" + size + "]";
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

	public int getSize()
	{
		return this.size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

}
