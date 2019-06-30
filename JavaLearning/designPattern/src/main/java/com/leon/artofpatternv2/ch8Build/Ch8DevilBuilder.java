package com.leon.artofpatternv2.ch8Build;

public class Ch8DevilBuilder extends Ch8ActorBuilder
{
	@Override
	public void buildType()
	{
		this.product.setType("devil");
	}

	@Override
	public void buildSex()
	{
		this.product.setSex("femal");
	}

	@Override
	public void buildFace()
	{
		this.product.setFace("argli");
	}
}
