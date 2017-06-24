package com.leon.artofpattern.chainRespons.exercise;

public class Leave
{
	private String name;
	private String reason;
	private int day;

	public Leave(String name, String reason, int day)
	{
		super();
		this.name = name;
		this.reason = reason;
		this.day = day;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getReason()
	{
		return this.reason;
	}

	public void setReason(String reason)
	{
		this.reason = reason;
	}

	public int getDay()
	{
		return this.day;
	}

	public void setDay(int day)
	{
		this.day = day;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(this.name + " 因\"" + this.reason + "\"请假" + this.day + "天");
		return sb.toString();
	}
}
