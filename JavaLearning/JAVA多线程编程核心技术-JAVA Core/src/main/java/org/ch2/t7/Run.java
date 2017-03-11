package org.ch2.t7;

public class Run
{
	public static void main(String[] args)
	{
		/**
		 * 同步方法按固定顺序读出的，
		 * 非同步方法，可能按不同顺序读出
		 */
		Task task = new Task();
		MyThread1 thread1 = new MyThread1(task);
		thread1.start();
		MyThread2 thread2 = new MyThread2(task);
		thread2.start();
	}
}
