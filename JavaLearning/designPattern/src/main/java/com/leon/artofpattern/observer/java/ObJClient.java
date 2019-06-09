package com.leon.artofpattern.observer.java;

import java.util.Observer;

public class ObJClient
{
	public static void main(String[] args)
	{
		ContreteObserable obserable = new ContreteObserable();
		Observer player = new Player();
		obserable.addObserver(player);
		Observer player2 = new Player();
		obserable.addObserver(player2);
		obserable.setData("12");// 通知所有观察者，数据有变化了
	}
}
