package org.ch3.ch31;

import java.util.ArrayList;
import java.util.List;

public class MyList
{
	private List<Object> list = new ArrayList<Object>();

	public void add()
	{
		this.list.add("leon");
	}

	public int size()
	{
		return list.size();
	}


}
