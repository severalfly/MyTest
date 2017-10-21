package com.leon.wechart.util;

import java.util.regex.Pattern;

public class TrainUtil
{
	private static Pattern trainPattern = Pattern.compile("([\\d]{1,4}|[gdcGDCtklTKL][\\d]{1,3})");

	public static boolean isTrainCode(String trainCode)
	{
		if (ObjectUtil.isNull(trainCode))
		{
			return false;
		}
		return trainPattern.matcher(trainCode).matches();
	}

	public static boolean containsTrain(String str)
	{
		if (ObjectUtil.isNull(str))
		{
			return false;
		}
		return trainPattern.matcher(str).find();
	}

}
