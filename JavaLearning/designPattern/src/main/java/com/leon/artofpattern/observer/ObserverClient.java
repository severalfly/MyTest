package com.leon.artofpattern.observer;

public class ObserverClient
{
	public static void main(String[] args)
	{
		AllyControlCenter acc = new ConcreteAllyControlCenter("浪一波");
		Observer player1 = new Player("杨过");
		acc.join(player1);
		Observer player2 = new Player("大冲");
		acc.join(player2);
		Observer player3 = new Player("无忌");
		acc.join(player3);
		Observer player4 = new Player("小段");
		acc.join(player4);

		player1.beAttacked(acc);
	}
}
