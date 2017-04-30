package com.leon.adapter;

public abstract class Player
{
	protected String name;

	public Player(String name)
	{
		super();
		this.name = name;
	}

	public abstract void attack();

	public abstract void defense();
}
