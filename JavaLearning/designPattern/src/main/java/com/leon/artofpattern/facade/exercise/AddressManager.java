package com.leon.artofpattern.facade.exercise;

public class AddressManager
{
	private String name;

	public AddressManager(String name)
	{
		super();
		this.name = name;
	}

	public void copy()
	{
		System.out.println("copy address: " + this.name);
	}
}
