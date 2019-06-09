package com.leon.adapter;

public class Translator extends Player
{
	ForeignCenter fc = new ForeignCenter();
	public Translator(String name)
	{
		super(name);
		fc.setName(name);
	}

	@Override
	public void attack()
	{
		fc.进攻();
	}

	@Override
	public void defense()
	{
		fc.防守();
	}

}
