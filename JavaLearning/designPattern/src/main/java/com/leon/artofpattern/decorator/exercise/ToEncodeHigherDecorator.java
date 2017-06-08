package com.leon.artofpattern.decorator.exercise;

public class ToEncodeHigherDecorator extends ToEncodeDecorator
{

	public ToEncodeHigherDecorator(ToEncodeData toEncodeData)
	{
		super(toEncodeData);
	}

	@Override
	public void encode()
	{
		super.encode();
		this.doHigherEncode();
	}

	private void doHigherEncode()
	{
		System.out.println("do higher encode");
	}
}
