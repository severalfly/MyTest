package com.leon.artofpattern.abstractfactory.exercise;

public class AndroidFactory implements SmartPhoneFacotry
{

	@Override
	public Operation createOperation()
	{
		return new AndroidOperation();
	}

	@Override
	public InterfaceController createInterfaceController()
	{
		return new AndroidInterfaceController();
	}

}
