package com.leon.artofpattern.abstractfactory.exercise;

public interface SmartPhoneFacotry
{
	public Operation createOperation();

	public InterfaceController createInterfaceController();
}
