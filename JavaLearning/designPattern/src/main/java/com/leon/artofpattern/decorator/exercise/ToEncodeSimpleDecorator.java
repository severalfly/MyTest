package com.leon.artofpattern.decorator.exercise;

public class ToEncodeSimpleDecorator extends ToEncodeDecorator
{

	public ToEncodeSimpleDecorator(ToEncodeData toEncodeData)
	{
		super(toEncodeData);
	}

	@Override
	public void encode()
	{
		super.encode();
		this.simpleEncode();
	}

	private void simpleEncode()
	{

		System.out.println("simple method encode");
	}
}
