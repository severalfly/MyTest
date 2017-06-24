package com.leon.artofpattern.iterator;

import java.util.List;

public class ProductList extends AbstractObjectList
{

	public ProductList(List<Object> products)
	{
		super(products);
	}

	@Override
	public AbstractIterator createIterator()
	{
		return new ProductIteratorV2();
	}

	private class ProductIteratorV2 implements AbstractIterator
	{
		private int cursor1;
		private int cursor2;

		public ProductIteratorV2()
		{
			super();
			this.cursor1 = 0;
			this.cursor2 = objects.size() - 1;
		}

		@Override
		public void next()
		{
			if (this.cursor1 < objects.size())
			{
				this.cursor1++;
			}
		}

		@Override
		public boolean isLast()
		{
			return this.cursor1 == objects.size();
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
			return objects.get(this.cursor1);
		}

		@Override
		public Object getPreviousItem()
		{
			return objects.get(this.cursor2);
		}

	}
}
