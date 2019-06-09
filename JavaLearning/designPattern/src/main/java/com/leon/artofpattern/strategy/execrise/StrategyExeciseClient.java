package com.leon.artofpattern.strategy.execrise;

import com.leon.util.XMLUtil;

public class StrategyExeciseClient
{
	public static void main(String[] args)
	{
		SimulatePlane simulater = new SimulatePlane();

		simulater.setPlane((Plane) XMLUtil.getBean("strategyExecise"));
		simulater.start();
	}
}
