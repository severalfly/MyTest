package com.leon.artofpatternv2.ch8Build;

public class Ch8HeroBuilder extends Ch8ActorBuilder
{
	@Override
	public void buildType()
	{
		this.product.setType("hero");
	}

	@Override
	public void buildSex()
	{
		this.product.setSex("man");
	}

	@Override
	public void buildFace()
	{
		this.product.setFace("beautiful");
	}
}
