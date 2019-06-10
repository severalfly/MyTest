package com.leon.artofpatternv2.ch4simplefactory;

public class ChartFactory
{
	public static Chart getChart(String type)
	{
		switch (type)
		{
		case "pie":
			return new PieChart();
		case "line":
			return new LineChart();
		default:
			return null;
		}
	}
}
