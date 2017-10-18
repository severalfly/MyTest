package com.leon.wechart.util;

import java.util.regex.Pattern;

import org.junit.Test;

public class TrainUtil
{
	private static Pattern pattern = Pattern.compile("[\\d]{1,4}||[gdcGDCtklTKL][\\d]{1,3}");

	public static boolean isTrainCode(String trainCode)
	{
		if (ObjectUtil.isNull(trainCode))
		{
			return false;
		}
		return pattern.matcher(trainCode).matches();
	}

	@Test
	public void testIsTrainCode()
	{
		System.out.println(isTrainCode("123"));
		System.out.println(isTrainCode("T123"));
		System.out.println(isTrainCode("T12345"));
		System.out.println(isTrainCode("01"));
		System.out.println(isTrainCode("T1000"));
		System.out.println(isTrainCode("T"));
	}
}
