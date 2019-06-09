package com.leon.artofpattern.observer.java;

import java.util.Observable;
import java.util.Observer;

/**
 * 这里的一个观察者
 * @author leon
 *
 */
public class Player implements Observer
{

	@Override
	public void update(Observable o, Object arg)
	{
		System.out.println("player update " + ((ContreteObserable) o).getData());
		// 有更新操作时，通知其他观察者。 
	}

}
