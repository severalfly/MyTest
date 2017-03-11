package org.ch2.t8;

public class Run
{
	public static void main(String[] args) throws InterruptedException
	{
		Task task = new Task();
		MyThread1 thread1 = new MyThread1(task);
		thread1.start();
		Thread.sleep(50);
		MyThread2 thread2 = new MyThread2(task);
		thread2.start();
	}
}
