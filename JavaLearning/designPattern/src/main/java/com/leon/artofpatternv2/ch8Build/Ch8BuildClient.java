package com.leon.artofpatternv2.ch8Build;

import com.leon.util.XMLUtil;

public class Ch8BuildClient
{
	public static void main(String[] args)
	{
		Ch8ActorBuilder builder = (Ch8ActorBuilder) XMLUtil.getBean("builderPatternv2");
		Ch8ActorController controller = new Ch8ActorController();
		Ch8Actor actor = controller.construct(builder);

		System.out.println(actor);

	}
}
