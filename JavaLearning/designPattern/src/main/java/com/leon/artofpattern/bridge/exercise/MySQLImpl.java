package com.leon.artofpattern.bridge.exercise;

public class MySQLImpl implements FormatImp
{

	@Override
	public void change()
	{
		System.out.println("change in mysql");
	}

}
