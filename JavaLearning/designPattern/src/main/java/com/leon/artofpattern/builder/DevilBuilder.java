package com.leon.artofpattern.builder;

public class DevilBuilder extends ActorBuilder
{

	@Override
	public void buildType()
	{
		this.actor.setType("devil");
	}

	@Override
	public void buildSex()
	{
		this.actor.setSex("male");
	}

	@Override
	public void buildFace()
	{
		this.actor.setFace("dirty");
	}

}
