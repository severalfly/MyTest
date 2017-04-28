package com.leon.decorator.result;

public class DecoratorMain
{
	public static void main(String[] args)
	{
		Person xc = new Person("xc");

		TShirts t = new TShirts();
		BigTrouser b = new BigTrouser();

		t.decorator(xc);
		b.decorator(t);

		b.show();
	}
}
