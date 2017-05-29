package com.leon.artofpattern.factorymethod;

public class DatabaseLogger implements Logger
{

	@Override
	public void writeLog()
	{
		System.out.println("write database logger");
	}

}
