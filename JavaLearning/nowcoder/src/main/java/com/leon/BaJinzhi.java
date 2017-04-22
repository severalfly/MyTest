package com.leon;

/**
 * 输入包括一个整数N(0<=N<=100000)。
 * 输入一个整数，将其转换成八进制数输出。 
 * @author leon
 *
 */
public class BaJinzhi
{
	public static void main(String[] args)
	{
		String result = "";
		int n = 7;
		while (n / 8 > 0)
		{
			result += n % 8;
			n = n / 8;
		}
		result += n % 8;
		System.out.println(result);
	}
}
