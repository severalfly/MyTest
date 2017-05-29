package com.leon.artofpattern.factorymethod;

import com.leon.util.XMLUtil;

public class FactoryMethodClient
{
	public static void main(String[] args)
	{
		//		LoggerFactory factory = new FileLoggerFactory();
		LoggerFactory factory = (LoggerFactory) XMLUtil.getBean("factoryMethod");
		Logger logger = factory.createLogger();
		logger.writeLog();
	}
}
