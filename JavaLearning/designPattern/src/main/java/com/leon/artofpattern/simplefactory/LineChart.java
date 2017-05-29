package com.leon.artofpattern.simplefactory;

public class LineChart implements Chart
{
	public LineChart()
	{
		System.out.println("create line chart");
	}

	public void display()
	{
		System.out.println("display line chart");
	}
}
