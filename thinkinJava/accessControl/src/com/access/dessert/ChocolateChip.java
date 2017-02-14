package com.access.dessert;
import com.access.cookie2.Cookie;

public class ChocolateChip extends Cookie
{
	public ChocolateChip()
	{
		System.out.println("ChocolateChip constructor");
	}
	public void chomp()
	{
		bite();
	}
	public static void main(String[] args)
	{
		ChocolateChip x = new ChocolateChip();
		x.chomp();
	}
}