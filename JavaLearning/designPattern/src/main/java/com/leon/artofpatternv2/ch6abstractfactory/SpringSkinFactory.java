package com.leon.artofpatternv2.ch6abstractfactory;

public class SpringSkinFactory implements SkinFactory
{
	@Override
	public Button createButton()
	{
		return new SpringButton();
	}

	@Override
	public TextField createTextField()
	{
		return new SpringTextField();
	}
}
