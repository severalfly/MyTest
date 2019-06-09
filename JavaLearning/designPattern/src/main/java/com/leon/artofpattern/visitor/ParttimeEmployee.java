package com.leon.artofpattern.visitor;

public class ParttimeEmployee implements Emploee
{
	private String name;
	private double hourWage;
	private int workTime;

	public ParttimeEmployee(String name, double hourWage, int workTime)
	{
		super();
		this.name = name;
		this.hourWage = hourWage;
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

	public double getHourWage()
	{
		return this.hourWage;
	}

	public void setHourWage(double hourWage)
	{
		this.hourWage = hourWage;
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
