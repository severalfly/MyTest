package com.leon.artofpattern.builder;

public class ActorController
{
	public Actor construct(ActorBuilder ab)
	{
		ab.buildType();
		ab.buildSex();
		ab.buildFace();
		return ab.createActor();
	}
}
