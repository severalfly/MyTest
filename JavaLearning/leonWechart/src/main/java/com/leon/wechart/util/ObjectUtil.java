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

	public static String getString(Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		return obj.toString();
	}

	public static long getLong(Object obj)
	{
		if (obj == null)
		{
			return 0;
		}
		return Long.parseLong(getString(obj));
	}
}
