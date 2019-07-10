package com.leon.artofpatternv2.ch15proxy;

import java.util.Date;

public class Ch15ProxyClient
{
	public static void main(String[] args)
	{

		Searcher searcher = new ProxySearcher();
		searcher.doSearch("yangguo", "yunvxinjing");
	}
}

interface Searcher
{
	public String doSearch(String userid, String keyword);
}

class AccessValidator
{
	public boolean validate(String userid)
	{
		System.out.println(this.getClass().getSimpleName() + " 验证是否合法 " + userid);
		if ("yangguo".equalsIgnoreCase(userid))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

class Ch15Logger
{
	public void log(String userid)
	{
		System.out.println("记录日志，userid: " + userid + " 请求次数加一");
	}
}

class RealSearcher implements Searcher
{

	@Override
	public String doSearch(String userid, String keyword)
	{
		System.out.println("用户: " + userid + " 使用关键词搜索: " + keyword);
		return "搜索结果: " + new Date().toString();
	}
}

class ProxySearcher implements Searcher
{
	private RealSearcher realSearcher = new RealSearcher();

	@Override
	public String doSearch(String userid, String keyword)
	{
		if (validate(userid))
		{
			String result = realSearcher.doSearch(userid, keyword);
			this.log(userid);
			return result;
		}
		else
		{
			return null;
		}
	}

	private AccessValidator accessValidator;
	private Ch15Logger logger;

	public boolean validate(String userid)
	{
		this.accessValidator = new AccessValidator();
		return accessValidator.validate(userid);
	}

	public void log(String userid)
	{
		this.logger = new Ch15Logger();
		logger.log(userid);

	}
}
