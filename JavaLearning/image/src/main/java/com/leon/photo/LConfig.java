package com.leon.photo;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

public class LConfig
{
	public static LConfig instance = new LConfig();
	private static Properties prop;
	public static String classUrl;
	public static String tomcatname;
	public static String tomcatpath;

	private LConfig()
	{
		try
		{
			URL url = LConfig.class.getResource("/");
			classUrl = url.getPath();

			int index = classUrl.indexOf("/webapps/");
			String path = classUrl.substring(0, index);
			index = path.lastIndexOf("/");

			tomcatname = path.substring(index + 1);

			System.out.println("lconfig" + new Date());
			/** qiniu.properties 内容，maven 放在resoures目录下面即可
			 access_key=your access key
			secret_key=your secret key
			 */
			FileInputStream fis = new FileInputStream(classUrl + "qiniu.properties");//属性文件流    
			prop = new Properties();
			prop.load(fis);//将属性文件流装载到Properties对象中   
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public String getProperty(String key)
	{
		return prop.getProperty(key);
	}
}
