package com.leon.artofpatternv2.ch8Build;

public class Ch8ActorController
{
	@Deprecated
	public Ch8Actor construct(Ch8ActorBuilder ab)
	{
		Ch8Actor actor=null;
		ab.buildType();
		ab.buildSex();
		ab.buildFace();

//		actor = ab.getResult();
		return actor;
	}
}
