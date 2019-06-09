package com.leon.artofpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 战队控制中心
 * @author leon
 *
 */
public abstract class AllyControlCenter
{
	protected String allyName;
	protected List<Observer> players = new ArrayList<Observer>();

	public void join(Observer obs)
	{
		System.out.println(obs.getName() + " join " + this.allyName);
		this.players.add(obs);
	}

	public void quit(Observer obs)
	{
		System.out.println(obs.getName() + " quit " + this.allyName);
		this.players.remove(obs);
	}

	public abstract void notifyObserver(String name);

	public String getAllyName()
	{
		return this.allyName;
	}

	public void setAllyName(String allyName)
	{
		this.allyName = allyName;
	}

}
