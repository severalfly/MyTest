package com.leon.artofpattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class IteratorClient
{
	public static void main(String[] args)
	{
		List<Object> products = new ArrayList<Object>();
		products.add("huo");
		products.add("li");
		products.add("tian");
		products.add("hui");
		products.add("cc");

		AbstractObjectList list = new ProductList(products);
		AbstractIterator iterator = list.createIterator();

		System.out.println("正向遍历");
		while (!iterator.isLast())
		{
			System.out.print(iterator.getNextItem() + ",");
			iterator.next();
		}

		System.out.println();
		System.out.println("----------------------");
		System.out.println("逆向遍历");
		while (!iterator.isFirst())
		{
			System.out.print(iterator.getPreviousItem() + ",");
			iterator.previous();
		}
	}

}
