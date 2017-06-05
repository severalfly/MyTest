package com.leon.artofpattern.builder;

import com.leon.util.XMLUtil;

public class BuilderClient
{
	public static void main(String[] args)
	{
		ActorBuilder ab = (ActorBuilder) XMLUtil.getBean("builderPattern");
		//		ActorController ac = new ActorController();
		Actor actor = ab.createActor();

		System.out.println(actor);
	}
}
