package com.leon.wechart.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.junit.Test;

public class TTTTTT
{
	@Test
	public void urlencode() throws UnsupportedEncodingException
	{
		System.out.println(URLEncoder.encode("南京", "gbk"));
		System.out.println(URLEncoder.encode("南京", "utf-8"));
		System.out.println("-E5-8D-97-E4-BA-AC".replaceAll("-", "%"));
		System.out.println(URLDecoder.decode("%E5%8D%97%E4%BA%AC", "utf-8"));
	}

}
