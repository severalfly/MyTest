package com.leon.artofpatternv2.ch6abstractfactory;

public class SummerSkinFactory implements SkinFactory
{
	@Override
	public Button createButton()
	{
		return new SummerButton();
	}

	@Override
	public TextField createTextField()
	{
		return new SummerTextField();
	}
}
