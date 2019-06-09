package com.leon.artofpattern.bridge.exercise;

public class SaveTxtFormat extends Format
{

	@Override
	public void save()
	{
		this.imp.change();
		System.out.println("saved as txt");
	}

}
