package com.leon.builder;

import java.util.ArrayList;
import java.util.List;

public class Product
{
	private List<String> parts = new ArrayList<String>();

	public void add(String part)
	{
		this.parts.add(part);
	}

	public void show()
	{
		System.out.println("\n产品创建---");
		for (String string : this.parts)
		{
			System.out.println(string);
		}
	}
}
