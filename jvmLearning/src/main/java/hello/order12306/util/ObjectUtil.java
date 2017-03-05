package hello.order12306.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ObjectUtil
{
	/**
	 * 获得当天日期如 2013-05-23
	 * @return 当天日期
	 */
	public static String getDay()
	{
		Date date = new Date(System.currentTimeMillis());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}
}
