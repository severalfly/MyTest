package com.leon.artofpattern.facade;

public class CipherMachine
{
	public String encrypt(String plainText)
	{
		String res = plainText + "-1 ";
		System.out.println("encrypted String: " + res);
		return res;
	}
}
