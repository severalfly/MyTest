package com.leon.artofpattern.proxy;

public class Logger
{
	public void log(String userid)
	{
		System.out.println("更新数据库，用户'" + userid + "'查询次数加1");

	}
}
