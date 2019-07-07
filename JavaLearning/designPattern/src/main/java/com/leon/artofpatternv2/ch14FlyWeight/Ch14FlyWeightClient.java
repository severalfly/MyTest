package com.leon.artofpatternv2.ch14FlyWeight;

import java.util.HashMap;
import java.util.Map;

public class Ch14FlyWeightClient
{
	public static void main(String[] args)
	{
		IgoChessman b = IgoChessmanFacotry.getIgoChessman("b");
		IgoChessman w1 = IgoChessmanFacotry.getIgoChessman("w");
		IgoChessman w2 = IgoChessmanFacotry.getIgoChessman("w");
		System.out.println(w1==w2);

		b.display();
	}
}

abstract class IgoChessman
{
	public abstract String getColor();

	public void display()
	{
		System.out.println("color: " + getColor());
	}
}

class BlackIgoChessman extends IgoChessman
{

	@Override
	public String getColor()
	{
		return "black";
	}
}


class WhiteIgoChessman extends IgoChessman
{

	@Override
	public String getColor()
	{
		return "white";
	}
}

class IgoChessmanFacotry
{
	private static Map<String ,IgoChessman> ht;
	public static IgoChessmanFacotry instance = new IgoChessmanFacotry();
	private IgoChessmanFacotry()
	{
		ht = new HashMap<>();
		ht.put("b", new BlackIgoChessman());
		ht.put("w", new WhiteIgoChessman());
	}

	public static IgoChessman getIgoChessman(String color)
	{
		return ht.get(color);
	}
}