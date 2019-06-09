package com.leon.decorator.result;

public class Person
{
	private String name;

	public Person()
	{
		super();
	}

	public Person(String name)
	{
		super();
		this.name = name;
	}

	public void show()
	{
		System.out.println("装扮的" + this.name);
	}
}
