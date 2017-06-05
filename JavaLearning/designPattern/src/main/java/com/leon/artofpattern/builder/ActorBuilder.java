package com.leon.artofpattern.builder;

public abstract class ActorBuilder
{
	protected Actor actor = new Actor();

	public abstract void buildType();

	public abstract void buildSex();

	public abstract void buildFace();

	public Actor createActor()
	{
		this.buildType();
		this.buildSex();
		this.buildFace();
		//		return ab.createActor();
		return this.actor;
	}
}
