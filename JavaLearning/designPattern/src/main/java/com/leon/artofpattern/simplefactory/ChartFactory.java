package com.leon.artofpattern.simplefactory;

public class ChartFactory
{
	public static Chart getChart(String type)
	{
		Chart chart = null;
		switch (type)
		{
		case "histogram":
			chart = new HistogramChart();
			System.out.println("initalizer histogram chart");
			break;
		case "line":
			chart = new LineChart();
			System.out.println("initalizer line chart");
			break;
		case "pie":
			chart = new PieChart();
			System.out.println("initalizer pic chart");
			break;

		default:
			break;
		}
		return chart;
	}
}
