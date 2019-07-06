package com.leon.artofpatternv2.ch9adapter;

import com.leon.util.XMLUtil;

public class Ch9Client
{
	public static void main(String[] args)
	{
		Ch9ScoreOperation adapter = (Ch9ScoreOperation) XMLUtil.getBean("adapterNamev2");

int[] array = new int[] {1,2};
		int search = adapter.search(array, 1);
		int[] sort = adapter.sort(array);

	}
}
