package com.leon.artofpatternv2.ch4simplefactory;

public class ChartClient
{
	public static void main(String[] args)
	{
		Chart chart = ChartFactory.getChart("line");
		chart.display();
	}
}
