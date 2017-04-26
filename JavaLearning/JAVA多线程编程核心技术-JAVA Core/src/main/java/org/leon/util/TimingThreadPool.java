package org.leon.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

public class TimingThreadPool extends ThreadPoolExecutor
{
	private final ThreadLocal<Long> startTime = new ThreadLocal<Long>();

	private final Logger log = Logger.getLogger("TimingThreadPool");
	private final AtomicLong numTasks = new AtomicLong();
	private final AtomicLong totalTime = new AtomicLong();

	@Override
	protected void beforeExecute(Thread t, Runnable r)
	{
		super.beforeExecute(t, r);
		System.out.println(String.format("Thread %s: start %s", t, r));
		startTime.set(System.currentTimeMillis());
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t)
	{
		try
		{
			long endTime = System.currentTimeMillis();
			long taskTime = endTime - startTime.get();
			numTasks.incrementAndGet();
			totalTime.addAndGet(taskTime);
			System.out.println(String.format("Thread %s: end %s, time=%dns", t, r, taskTime));
		}
		catch (Exception e)
		{
			super.afterExecute(r, t);
		}
	}

	@Override
	protected void terminated()
	{
		try
		{
			System.out.println(String.format("Terminated: avg time=%dns", totalTime.get() / numTasks.get()));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue)
	{
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

}
