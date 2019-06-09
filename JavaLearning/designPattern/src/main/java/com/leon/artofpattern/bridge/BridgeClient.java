package com.leon.artofpattern.bridge;

import com.leon.util.XMLUtil;

public class BridgeClient
{
	public static void main(String[] args)
	{
		Image image = (Image) XMLUtil.getBean("bridgeImage");
		ImageImp imp = (ImageImp) XMLUtil.getBean("bridgeImp");
		image.setImp(imp);
		image.parseFile("小龙女");
	}
}
