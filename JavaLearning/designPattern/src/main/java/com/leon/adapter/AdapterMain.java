package com.leon.adapter;

public class AdapterMain
{
	public static void main(String[] args)
	{
		Player b = new Forwards("巴蒂尔");
		b.attack();

		Player m = new Translator("姚明");
		m.attack();
		m.defense();
	}
}
