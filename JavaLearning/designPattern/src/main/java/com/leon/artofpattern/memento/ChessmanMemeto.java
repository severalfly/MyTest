package com.leon.artofpattern.memento;

public class ChessmanMemeto
{
	private String label;
	private int x;
	private int y;

	public ChessmanMemeto(String label, int x, int y)
	{
		this.label = label;
		this.x = x;
		this.y = y;
	}

	public String getLabel()
	{
		return this.label;
	}

	public void setLabel(String label)
	{
		this.label = label;
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
