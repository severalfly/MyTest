package com.leon.artofpattern.proxy;

public class RealSearcher implements Seacher
{

	@Override
	public String doSearch(String userid, String keyword)
	{
		System.out.println("e用户" + userid + "使用关键词" + keyword + "查询商务信息");
		return "查询具体内容";
	}

}
