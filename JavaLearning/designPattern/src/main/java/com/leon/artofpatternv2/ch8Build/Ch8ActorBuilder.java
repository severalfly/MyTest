package com.leon.artofpatternv2.ch8Build;

public abstract class Ch8ActorBuilder
{
	Ch8Actor product = new Ch8Actor();

	public abstract void buildType();

	public abstract void buildSex();

	public abstract void buildFace();

	public Ch8Actor getResult()
	{
		return product;
	}

}
