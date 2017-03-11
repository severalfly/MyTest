package org.ch2.synTwoLock;

public class Service
{
	synchronized public static void printA()
	{
		try
		{
			System.out.println("线程名称： " + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + " 进入printA");
			Thread.sleep(3000);
			System.out.println("线程名称： " + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + " 离开printA");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	synchronized public static void printB()
	{
		try
		{
			System.out.println("线程名称： " + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + " 进入printB");
			System.out.println("线程名称： " + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + " 离开printB");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	synchronized public void printC()
	{
		try
		{
			System.out.println("线程名称： " + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + " 进入printC");
			Thread.sleep(3000);
			System.out.println("线程名称： " + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + " 离开printC");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
