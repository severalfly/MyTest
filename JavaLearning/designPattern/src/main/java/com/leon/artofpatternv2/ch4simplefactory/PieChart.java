package com.leon.artofpatternv2.ch4simplefactory;

public class PieChart implements Chart
{
	public PieChart()
	{
		System.out.println("piechart create");
	}

	@Override
	public void display()
	{
		System.out.println("pie chart display");
	}
}
