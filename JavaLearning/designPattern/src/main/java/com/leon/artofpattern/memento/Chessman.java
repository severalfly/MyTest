package com.leon.artofpattern.memento;

public class Chessman
{
	private String label;
	private int x;
	private int y;

	public Chessman(String label, int x, int y)
	{
		super();
		this.label = label;
		this.x = x;
		this.y = y;
	}

	public ChessmanMemeto save()
	{
		return new ChessmanMemeto(this.label, this.x, this.y);
	}

	public void restore(ChessmanMemeto memeto)
	{
		this.label = memeto.getLabel();
		this.x = memeto.getX();
		this.y = memeto.getY();
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("棋子'");
		sb.append(this.label);
		sb.append("'当前位置为：第");
		sb.append(this.x);
		sb.append("行，第");
		sb.append(this.y);
		sb.append("列。");
		return sb.toString();
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
