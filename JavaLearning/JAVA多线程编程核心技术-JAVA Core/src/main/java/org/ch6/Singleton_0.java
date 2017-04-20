package org.ch6;

public class Singleton_0
{
	public static void main(String[] args)
	{

		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		t1.start();
		t2.start();
		t3.start();
	}
}

class MyObject
{
	private static MyObject myObject = new MyObject();

	private MyObject()
	{
	}

	public static MyObject getInstance()
	{
		// 此代码版本为立即加载，
		// 不能有其他实例变量
		// 因为getInstance 方法没有同步
		// 所以有可能出现非线程安全问题
		return myObject;
	}
}

class MyThread extends Thread
{
	@Override
	public void run()
	{
		System.out.println(MyObject.getInstance().hashCode());
	}
}
