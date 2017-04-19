package org.ch3.p_r_allwait;

public class P
{
	private String lock;

	public P(String lock)
	{
		super();
		this.lock = lock;
	}

	public void setValue()
	{
		try
		{
			synchronized (lock)
			{
				while (!ValueObject.value.equals(""))
				{
					System.out.println("product " + Thread.currentThread().getName() + " waiting");
					lock.wait();
				}
				System.out.println("product " + Thread.currentThread().getName() + " runnable");
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				System.out.println("the value of set is: " + value);
				ValueObject.value = value;
				lock.notify();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
