package com.leon.wechart.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


public class HttpServletRequestUtil
{
	/**
	 * 从请求流中读取参数
	 */
	public static String getParamFromRequestStream() throws Exception
	{
		StringBuffer sb = new StringBuffer();
		HttpServletRequest request = ServletActionContext.getRequest();
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
		try
		{
			String tempString = null;
			while ((tempString = reader.readLine()) != null)
			{
				sb.append(tempString);
			}
			return sb.toString();
		}
		finally
		{
			LeonFileUtil.closeStream(reader);
		}
	}
}
