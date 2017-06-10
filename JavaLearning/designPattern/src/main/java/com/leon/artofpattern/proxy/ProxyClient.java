package com.leon.artofpattern.proxy;

public class ProxyClient
{
	public static void main(String[] args)
	{
		Seacher seacher = new ProxySearcher();
		seacher.doSearch("hehe", "玉女心经");
	}
}
