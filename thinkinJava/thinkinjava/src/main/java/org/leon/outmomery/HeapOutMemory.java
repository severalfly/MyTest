package org.leon.outmomery;

import java.util.LinkedList;
import java.util.List;

/**
 * 做个堆溢出
 * @author megan
 *
 */
public class HeapOutMemory
{
	public static void main(String[] args)
	{
		List<HeapOutMemoryRecord> list = new LinkedList<>();
		if (1 < 2)
		{
			list.add(new HeapOutMemoryRecord());
		}
		String s = "";
	}
}

class HeapOutMemoryRecord
{
	private int[] a;

	public HeapOutMemoryRecord()
	{
		this.a = new int[1024 * 1024 * 1024];
	}
}
