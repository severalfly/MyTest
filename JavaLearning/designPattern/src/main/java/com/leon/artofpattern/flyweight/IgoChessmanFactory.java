package com.leon.artofpattern.flyweight;

import java.util.Hashtable;

public class IgoChessmanFactory
{
	private static IgoChessmanFactory instance = new IgoChessmanFactory();
	private static Hashtable<String, IgoChessman> ht;

	private IgoChessmanFactory()
	{
		ht = new Hashtable<String, IgoChessman>();
		IgoChessman white, black;

		white = new WhiteIgoChessman();
		ht.put("w", white);
		black = new BlackIgoChessman();
		ht.put("b", black);

	}

	public static IgoChessmanFactory getInstance()
	{
		return instance;
	}

	public static IgoChessman getIgoChessman(String color)
	{
		return ht.get(color);
	}
}
