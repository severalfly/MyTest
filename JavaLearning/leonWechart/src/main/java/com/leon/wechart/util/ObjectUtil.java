package com.leon.wechart.util;

import java.text.SimpleDateFormat;
import java.util.Date;

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

	/**
	 * 获取当前日期
	 * @return
	 */
	public static String getDay()
	{
		Date date = new Date();
		return new SimpleDateFormat("yyyy-MM-hh").format(date);
	}

}
