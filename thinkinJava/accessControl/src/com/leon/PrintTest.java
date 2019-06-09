package com.leon;
import static com.leon.util.Print.*;
import static com.leon.util.Range.*;
public class PrintTest
{
	public static void main(String[] args) {
		print("you can see now");
		print(0);
		print(100l);
		print(3.413);
		int[] ra = range(10);
		for (int i : ra) {
			print(i);
		}
	}
}