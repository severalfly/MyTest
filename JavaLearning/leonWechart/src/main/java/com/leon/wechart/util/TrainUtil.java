package com.leon.wechart.util;

import java.util.regex.Matcher;
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

	public static String containsTrain(String str)
	{
		if (ObjectUtil.isNull(str))
		{
			return "";
		}
		Matcher matcher = trainPattern.matcher(str);
		if (matcher.find())
		{
			return matcher.group(1);
		}
		else
		{
			return "";
		}
	}

	public static Pair<String, String> getTrainCodeStating(String str)
	{
		String trainCode = containsTrain(str);
		if (ObjectUtil.isNull(trainCode))
		{
			return null;
		}
		String station = str.replace(trainCode, "");
		if (ObjectUtil.isNull(station.trim()))
		{
			return null;
		}
		return new Pair<String, String>(trainCode, station.trim());
	}
}
