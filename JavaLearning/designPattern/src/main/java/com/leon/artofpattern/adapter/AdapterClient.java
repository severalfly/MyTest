package com.leon.artofpattern.adapter;

import com.leon.util.XMLUtil;

public class AdapterClient
{
	public static void main(String[] args)
	{
		ScoreOperation operation = (ScoreOperation) XMLUtil.getBean("adapterName");
		//		operation.
		int[] scores = { 54, 76, 45, 98, 12 };
		for (int i : scores)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		scores = operation.sort(scores);
		for (int i : scores)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(operation.search(scores, 9));
	}
}
