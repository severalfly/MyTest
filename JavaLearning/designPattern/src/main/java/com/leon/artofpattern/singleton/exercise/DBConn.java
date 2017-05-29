package com.leon.artofpattern.singleton.exercise;

public class DBConn
{

}

class EDBConn
{
	public static EDBConn instance = new EDBConn();

	private EDBConn()
	{

	}

	public static EDBConn getInstance()
	{
		return instance;
	}
}

class LDBCon
{
	// 懒汉
	public static LDBCon instance = null;

	private LDBCon()
	{

	}

	public static LDBCon getInstance()
	{
		if (instance == null)
		{
			instance = new LDBCon();
		}
		return instance;
	}
}

class IoDHDBConn
{
	private IoDHDBConn()
	{

	}

	private static class IoDHConnHolder
	{
		public static final IoDHDBConn instance = new IoDHDBConn();
	}

	public static IoDHDBConn getInstance()
	{
		return IoDHConnHolder.instance;
	}
}