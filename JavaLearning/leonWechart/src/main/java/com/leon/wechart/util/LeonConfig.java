package com.leon.wechart.util;

import java.util.Properties;

public class LeonConfig
{
	private static LeonConfig instance = new LeonConfig();

	private Properties p = null;

	private LeonConfig()
	{
		try
		{
			p = new Properties();
			//			p.load(new FileInputStream(new File("./classes/config.properties")));
			p.load(LeonConfig.class.getResourceAsStream("/config.properties"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static String getProperties(String key)
	{
		return instance.p.getProperty(key);
	}

	public static int getPropertyInt(String key)
	{
		return Integer.parseInt(instance.p.getProperty(key));
	}

	public static long getPropertyLong(String key)
	{
		return Long.parseLong(instance.p.getProperty(key));
	}

}