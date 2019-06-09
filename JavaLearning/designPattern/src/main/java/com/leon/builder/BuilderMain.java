package com.leon.builder;

public class BuilderMain
{
	public static void main(String[] args)
	{
		Director director = new Director();

		Builder builder = new ConcreteBuilder1();
		director.construct(builder);
		Product p1 = builder.getResult();
		p1.show();

		builder = new ConcreteBuilder2();
		director.construct(builder);
		Product p2 = builder.getResult();
		p2.show();
	}
}
