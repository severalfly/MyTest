package com.leon.artofpattern.factorymethod.exercise;

import com.leon.util.XMLUtil;

public class FactoryMethodClientV2
{
	public static void main(String[] args)
	{
		try
		{
			PicReader reader = (PicReader) XMLUtil.getBean("factoryMethodExercise");
			reader.reader();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
