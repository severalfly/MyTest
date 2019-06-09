package com.leon.artofpattern.bridge.exercise;

public class SaveXmlFormat extends Format
{

	@Override
	public void save()
	{
		this.imp.change();
		System.out.println("saved as xml");
	}

}
