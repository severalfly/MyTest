package com.leon.artofpatternv2.ch4simplefactory;

public class LineChart implements Chart
{
	public LineChart()
	{
		System.out.println("line chart create");
	}
	@Override
	public void display()
	{
		System.out.println("line chart display");
	}
}
