package com.leon;

import java.util.Scanner;

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

		Scanner scanner = new Scanner(System.in);
		while (true)
		{
			out(result, scanner);
		}
	}

	private static void out(String result, Scanner scanner)
	{
		int n = scanner.nextInt();
		while (n / 8 > 0)
		{
			result = n % 8 + result;
			n = n / 8;
		}
		result = n % 8 + result;
		System.out.println(result);
	}
}
