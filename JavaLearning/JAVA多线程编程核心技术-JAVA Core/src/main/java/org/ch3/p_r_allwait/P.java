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
				if (!ValueObject.value.equals(""))
				{
					lock.wait();
				}
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
