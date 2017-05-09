package com.leon.effectiveJava.entry05;

public class SumInt
{
	public static void main(String[] args)
	{
		long now = System.currentTimeMillis();
		long sum = 0l; // 不会自动装箱
		//		Long sum = 0l; // 会自动装箱，很慢
		for (long i = 0l; i < Integer.MAX_VALUE; i++)
		{
			sum += i;
		}
		System.out.println(sum);
		System.out.println(System.currentTimeMillis() - now);
	}
}
