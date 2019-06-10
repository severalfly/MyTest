package com.leon.artofpatternv2.ch4simplefactory;

import com.leon.util.XMLUtil;

public class ChartClient
{
	public static void main(String[] args)
	{
		String charttype = XMLUtil.getCharttype();
		Chart chart = ChartFactory.getChart(charttype);
		chart.display();
	}
}
