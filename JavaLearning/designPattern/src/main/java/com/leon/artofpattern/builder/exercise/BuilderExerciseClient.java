package com.leon.artofpattern.builder.exercise;

import com.leon.util.XMLUtil;

public class BuilderExerciseClient
{
	public static void main(String[] args)
	{

		ShowerBuilder sb = (ShowerBuilder) XMLUtil.getBean("builderExercisePattern");
		Shower shower = sb.createShower();
		System.out.println(shower);
	}
}
