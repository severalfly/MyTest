package com.leon.artofpattern.abstractfactory.exercise;

public class IosFactory implements SmartPhoneFacotry
{

	@Override
	public Operation createOperation()
	{
		return new IosOperation();
	}

	@Override
	public InterfaceController createInterfaceController()
	{
		return new IosInerfaceController();
	}

}
