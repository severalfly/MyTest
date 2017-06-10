package com.leon.artofpattern.proxy;

public class AccessValidator
{
	// 身份验证类
	public boolean validate(String userid)
	{
		System.out.println("在数据库中验证" + userid + "是否合法");
		if (userid.equalsIgnoreCase("hehe"))
		{
			System.out.println("'" + userid + "'登录成功!");
			return true;
		}
		else
		{
			System.out.println("'" + userid + "'登录失败");
			return false;
		}
	}
}
