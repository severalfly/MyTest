package com.leon.proxy;

public class ProxyMain
{
	public static void main(String[] args)
	{
		SchoolGirl mm = new SchoolGirl("qiaoqiao");
		mm.setName("qiaoqiao");

		Proxy proxy = new Proxy(mm);
		proxy.giveDolls();
		proxy.giveFlowers();
		proxy.giveChocolate();
	}
}
