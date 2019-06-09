package com.leon.builder;

public class ConcreteBuilder1 extends Builder
{
	private Product product = new Product();

	@Override
	public void bilderPartA()
	{
		this.product.add("部件A");
	}

	@Override
	public void bilderPartB()
	{
		this.product.add("部件B");

	}

	@Override
	public Product getResult()
	{
		return this.product;
	}
}
