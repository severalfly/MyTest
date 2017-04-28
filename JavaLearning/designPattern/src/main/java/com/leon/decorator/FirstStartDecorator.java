package com.leon.decorator;

public class FirstStartDecorator
{
	public static void main(String[] args)
	{
		Person xc = new Person("severalfly");
		System.out.println("第一种装扮");
		xc.wearTShirts();
		xc.show();
		System.out.println();
		System.out.println("第二种装扮");
		xc.wearBigTrouse();
		xc.show();
	}
}

class Person
{
	private String name;

	public Person(String name)
	{
		super();
		this.name = name;
	}

	public void wearTShirts()
	{
		System.out.println("大T恤");
	}

	public void wearBigTrouse()
	{
		System.out.println("垮裤");
	}

	public void show()
	{
		System.out.println("装扮的" + this.name);
	}
}
