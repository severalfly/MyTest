package com.leon.wechart.util;

import java.util.regex.Pattern;

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


}
