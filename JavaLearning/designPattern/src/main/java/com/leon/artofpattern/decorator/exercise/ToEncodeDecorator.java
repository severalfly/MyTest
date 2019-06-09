package com.leon.artofpattern.decorator.exercise;

public class ToEncodeDecorator extends ToEncodeData
{
	private ToEncodeData toEncodeData;

	public ToEncodeDecorator(ToEncodeData toEncodeData)
	{
		super();
		this.toEncodeData = toEncodeData;
	}

	@Override
	public void encode()
	{
		this.toEncodeData.encode();
	}

}
