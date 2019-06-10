package com.leon.artofpatternv2.ch5factory;

public class Ch5DatabaseLogger implements Ch5Logger
{
	@Override
	public void writeLog()
	{
		System.out.println("database logger write log");
	}
}
