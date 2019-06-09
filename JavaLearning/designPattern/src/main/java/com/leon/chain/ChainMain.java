package com.leon.chain;

import java.util.ArrayList;
import java.util.List;

public class ChainMain
{
	public static void main(String[] args)
	{
		Handler h1 = new ConcreteHandler1();
		Handler h2 = new ConcreteHandler2();
		Handler h3 = new ConcreteHandler3();
		h1.setSuccessor(h2);
		h2.setSuccessor(h3);

		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(5);
		list.add(14);
		list.add(22);
		list.add(18);
		list.add(3);
		list.add(27);
		list.add(20);
		for (Integer i : list)
		{
			h1.handleRequest(i);
		}

	}
}
