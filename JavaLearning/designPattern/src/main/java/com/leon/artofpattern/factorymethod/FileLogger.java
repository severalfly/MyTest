package com.leon.artofpattern.factorymethod;

public class FileLogger implements Logger
{

	@Override
	public void writeLog()
	{
		System.out.println("write file logger");
	}

}
