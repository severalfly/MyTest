package com.leon.artofpattern.factorymethod;

public class FileLoggerFactory implements LoggerFactory
{

	@Override
	public Logger createLogger()
	{
		return new FileLogger();
	}

}
