package com.leon.artofpattern.memento;

public class MementoClient
{
	public static void main(String[] args)
	{
		MementoCaretaker mc = new MementoCaretaker();

		Chessman chess = new Chessman("车", 1, 1);
		System.out.println(chess);
		mc.setMemeto(chess.save());
		chess.setY(4);
		System.out.println(chess);
		//		mc.setMemeto(chess.save());
		chess.setX(5);
		System.out.println(chess);

		chess.restore(mc.getMemeto());
		System.out.println(chess);
	}
}
