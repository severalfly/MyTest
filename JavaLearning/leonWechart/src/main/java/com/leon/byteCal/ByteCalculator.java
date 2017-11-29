package com.leon.byteCal;


public class ByteCalculator
{
	public static void main(String[] args)
	{
		int a = 3;
		int b = 7;
		int sum = a;
		int carry = b;
		do
		{
			int tmp = sum;
			sum = tmp ^ carry;
			carry = (tmp & carry) << 1;
		}
		while (carry > 0);
		System.out.println(sum);
	}

}
