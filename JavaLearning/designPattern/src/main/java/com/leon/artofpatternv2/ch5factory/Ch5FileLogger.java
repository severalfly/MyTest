package com.leon.artofpatternv2.ch5factory;

public class Ch5FileLogger implements Ch5Logger
{
	@Override
	public void writeLog()
	{
		System.out.println("file logger write log");
	}
}
