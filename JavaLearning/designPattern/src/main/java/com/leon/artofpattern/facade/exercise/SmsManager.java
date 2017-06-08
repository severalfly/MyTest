package com.leon.artofpattern.facade.exercise;

public class SmsManager
{
	private String name;

	public SmsManager(String name)
	{
		super();
		this.name = name;
	}

	public void copy()
	{
		System.out.println("copy sms: " + this.name);
	}
}
