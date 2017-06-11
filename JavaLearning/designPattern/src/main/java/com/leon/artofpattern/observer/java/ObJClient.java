package com.leon.artofpattern.observer.java;

import java.util.Observable;
import java.util.Observer;

public class ObJClient
{
	public static void main(String[] args)
	{
		Observable obserable = new ContreteObserable();
		Observer player = new Player();
		obserable.addObserver(player);

		player.update(obserable, new Object());
	}
}
