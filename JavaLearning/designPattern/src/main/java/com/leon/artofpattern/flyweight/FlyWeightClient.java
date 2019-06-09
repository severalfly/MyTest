package com.leon.artofpattern.flyweight;

public class FlyWeightClient
{
	public static void main(String[] args)
	{
		IgoChessmanFactory factory = IgoChessmanFactory.getInstance();
		IgoChessman back1 = factory.getIgoChessman("b");
		IgoChessman back2 = factory.getIgoChessman("b");
		IgoChessman back3 = factory.getIgoChessman("b");
		System.out.println("black1 == black2: " + (back1 == back2));

		IgoChessman white1 = factory.getIgoChessman("w");
		IgoChessman white2 = factory.getIgoChessman("w");
		System.out.println("white1 ==white2: " + (white1 == white2));

		back1.display(new Coordinates(1, 3));
		back2.display(new Coordinates(3, 5));
		back3.display(new Coordinates(1, 6));

		white1.display(new Coordinates(1, 7));
		white2.display(new Coordinates(2, 4));
	}
}
