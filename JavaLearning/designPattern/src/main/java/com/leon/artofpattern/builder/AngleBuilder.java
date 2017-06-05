package com.leon.artofpattern.builder;

public class AngleBuilder extends ActorBuilder
{

	@Override
	public void buildType()
	{
		this.actor.setType("angle");
	}

	@Override
	public void buildSex()
	{
		this.actor.setSex("female");
	}

	@Override
	public void buildFace()
	{
		this.actor.setFace("beautiful");
	}

}
