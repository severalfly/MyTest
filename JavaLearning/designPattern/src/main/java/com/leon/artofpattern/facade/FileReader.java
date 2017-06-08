package com.leon.artofpattern.facade;

import java.util.Random;

public class FileReader
{
	private Random random = new Random();
	private static String str = "huoli";

	public String read(String fileName)
	{
		String res = "" + str.charAt(random.nextInt(str.length())) + str.charAt(random.nextInt(str.length()));
		System.out.println("read file from: " + fileName + " and get: " + res);
		return res;
	}
}
