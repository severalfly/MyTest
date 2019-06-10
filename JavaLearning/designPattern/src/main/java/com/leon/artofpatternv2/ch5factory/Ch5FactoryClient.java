package com.leon.artofpatternv2.ch5factory;

import com.leon.util.XMLUtil;

public class Ch5FactoryClient
{
	public static void main(String[] args)
	{
//		Ch5Factory factory = new Ch5FileLoggerFactory();
		Ch5Factory factory = (Ch5Factory) XMLUtil.getBean("factoryMethodv2");
		Ch5Logger logger = factory.createLogger();
		logger.writeLog();
	}
}
