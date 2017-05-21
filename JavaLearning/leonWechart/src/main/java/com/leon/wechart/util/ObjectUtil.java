package com.leon.wechart.util;

public class ObjectUtil
{
	public static boolean isNull(Object obj)
	{
		if (obj == null || "".equals(obj.toString()))
		{
			return true;
		}
		return false;
	}

	public static boolean isNotNull(Object obj)
	{
		return !isNull(obj);
	}
}
