package com.leon.decorator.second;

public class SecondDecorator
{
	public static void main(String[] args)
	{
		Person xc  = new Person("xc");
		System.out.println("first mode");
		Finery t = new TShirts();
		Finery b = new BigTrouser();
		t.show();
		b.show();
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

	public void show()
	{
		System.out.println("decorator " + this.name);
	}
}

abstract class Finery
{
	abstract void show();
}

class TShirts extends Finery
{
	@Override
	public void show()
	{
		System.out.println("Tshirts");
	}
}

class BigTrouser extends Finery
{
	@Override
	void show()
	{
		System.out.println("BigTrouser");
	}

}
