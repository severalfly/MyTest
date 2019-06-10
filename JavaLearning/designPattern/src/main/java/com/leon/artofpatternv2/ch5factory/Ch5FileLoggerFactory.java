package com.leon.artofpatternv2.ch5factory;

public class Ch5FileLoggerFactory implements Ch5Factory
{
	@Override
	public Ch5Logger createLogger()
	{
		return new Ch5FileLogger();
	}
}
