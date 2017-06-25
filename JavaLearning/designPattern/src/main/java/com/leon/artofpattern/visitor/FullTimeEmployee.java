package com.leon.artofpattern.visitor;

public class FullTimeEmployee implements Emploee
{
	private String name;
	private double weeklyWage;
	private int workTime;

	public FullTimeEmployee(String name, double weeklyWage, int workTime)
	{
		super();
		this.name = name;
		this.weeklyWage = weeklyWage;
		this.workTime = workTime;
	}

	@Override
	public void accept(Department handler)
	{
		handler.visit(this);
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getWeeklyWage()
	{
		return this.weeklyWage;
	}

	public void setWeeklyWage(double weeklyWage)
	{
		this.weeklyWage = weeklyWage;
	}

	public int getWorkTime()
	{
		return this.workTime;
	}

	public void setWorkTime(int workTime)
	{
		this.workTime = workTime;
	}

}
