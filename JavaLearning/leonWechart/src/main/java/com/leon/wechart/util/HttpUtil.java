package com.leon.wechart.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class HttpUtil
{
	/**
	 * 获取数据
	 */
	public static String getParam(Map<String, String[]> map)
	{
		return getParam(map, false);
	}

	public static String getParam(Map<String, String[]> map, boolean encode)
	{
		return getInputParamsUrl(map, encode) + " " + HttpUtil.getRemoteIp(ServletActionContext.getRequest());
	}

	public static String getInputParamsUrl(Map<String, String[]> map, boolean encode)
	{
		if (map == null)
		{
			return null;
		}
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (Entry<String, String[]> entry : map.entrySet())
		{
			sb.append(entry.getKey()).append("=");
			int j = 0;
			for (String value : entry.getValue())
			{
				try
				{
					if (encode)
					{
						sb.append(URLEncoder.encode(value, "UTF-8"));
					}
					else
					{
						sb.append(value);
					}
				}
				catch (UnsupportedEncodingException e)
				{
				}
				if (j != entry.getValue().length - 1)
				{
					sb.append(",");
				}
				j++;
			}
			if (i != map.size() - 1)
			{
				sb.append("&");
			}
			i++;
		}
		return sb.toString();
	}

	public static String getRemoteIp(HttpServletRequest request)
	{
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
