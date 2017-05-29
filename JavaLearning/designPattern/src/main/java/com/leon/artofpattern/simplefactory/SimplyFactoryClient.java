package com.leon.artofpattern.simplefactory;

import com.leon.util.XMLUtil;

public class SimplyFactoryClient
{
	public static void main(String[] args)
	{
		Chart chart = ChartFactory.getChart("line");
		chart.display();

		String type = XMLUtil.getCharttype();
		chart = ChartFactory.getChart(type);
		chart.display();
	}
}
