package com.leon.thread;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestCallable
{
	public static void main(String[] args) throws Exception
	{
		TestCallableTT callable = new TestCallableTT();
		FutureTask<String> futureTask = new FutureTask<String>(callable);
		new Thread(futureTask).start();
		Thread.sleep(1000l);
		System.out.println(futureTask.get());

	}
}

class TestCallableTT implements Callable<String>
{
	@Override
	public String call() throws Exception
	{
		return "" + new Date();
	}

}
