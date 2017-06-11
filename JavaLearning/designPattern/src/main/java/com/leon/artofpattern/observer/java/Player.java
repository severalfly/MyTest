package com.leon.artofpattern.observer.java;

import java.util.Observable;
import java.util.Observer;

public class Player implements Observer
{

	@Override
	public void update(Observable o, Object arg)
	{
		System.out.println("player update");
		o.notifyObservers();
	}

}
