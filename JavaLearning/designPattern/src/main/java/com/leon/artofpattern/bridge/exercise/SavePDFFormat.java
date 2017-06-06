package com.leon.artofpattern.bridge.exercise;

public class SavePDFFormat extends Format
{

	@Override
	public void save()
	{
		this.imp.change();
		System.out.println("saved as pdf");
	}

}
