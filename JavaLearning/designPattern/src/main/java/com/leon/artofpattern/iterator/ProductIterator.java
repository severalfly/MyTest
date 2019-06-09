package com.leon.artofpattern.iterator;

import java.util.List;

public class ProductIterator implements AbstractIterator
{
	private ProductList productList;
	private List<Object> products;
	private int cursor1;
	private int cursor2;

	public ProductIterator(com.leon.artofpattern.iterator.ProductList list)
	{
		super();
		this.productList = list;
		this.products = this.productList.getObjects();
		this.cursor1 = 0;
		this.cursor2 = this.products.size() - 1;
	}

	@Override
	public void next()
	{
		if (this.cursor1 < products.size())
		{
			this.cursor1++;
		}
	}

	@Override
	public boolean isLast()
	{
		return this.cursor1 == this.products.size();
	}

	@Override
	public void previous()
	{
		if (this.cursor2 > -1)
		{
			this.cursor2--;
		}
	}

	@Override
	public boolean isFirst()
	{
		return this.cursor2 == -1;
	}

	@Override
	public Object getNextItem()
	{
		return this.products.get(this.cursor1);
	}

	@Override
	public Object getPreviousItem()
	{
		return this.products.get(this.cursor2);
	}

}
