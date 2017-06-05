package com.leon.artofpattern.builder;

public class HeroBuilder extends ActorBuilder
{

	@Override
	public void buildType()
	{
		this.actor.setType("hero");
	}

	@Override
	public void buildSex()
	{
		this.actor.setSex("male");
	}

	@Override
	public void buildFace()
	{
		this.actor.setFace("handsome");
	}

}
