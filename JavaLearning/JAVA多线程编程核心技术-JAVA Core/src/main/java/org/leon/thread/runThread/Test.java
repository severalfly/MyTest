package org.leon.thread.runThread;

/**
 * 获取线程名与线程id
 * @author leon
 *
 */
public class Test
{
	public static void main(String[] args)
	{
		Thread runThread = Thread.currentThread();
		System.out.println(runThread.getName() + " " + runThread.getId());
	}
}
