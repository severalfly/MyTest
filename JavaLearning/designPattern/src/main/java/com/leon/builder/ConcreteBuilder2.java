package com.leon.builder;

public class ConcreteBuilder2 extends Builder
{
	private Product product = new Product();

	@Override
	public void bilderPartA()
	{
		this.product.add("部件K");
	}

	@Override
	public void bilderPartB()
	{
		this.product.add("部件L");

	}

	@Override
	public Product getResult()
	{
		return this.product;
	}
}
