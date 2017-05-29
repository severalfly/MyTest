package com.leon.artofpattern.singleton;

public class SingletonV2
{
	private SingletonV2()
	{
		// 定义私有的构造方法
	}

	private static class HolderClass
	{
		private final static SingletonV2 instance = new SingletonV2();
	}

	public static SingletonV2 getInstance()
	{
		return HolderClass.instance;
	}
}
