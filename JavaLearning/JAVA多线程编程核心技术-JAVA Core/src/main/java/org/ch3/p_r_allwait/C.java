package org.ch3.p_r_allwait;

public class C
{
	private String lock;

	public C(String lock)
	{
		super();
		this.lock = lock;
	}

	public void getValue()
	{
		try
		{
			synchronized (lock)
			{
				if (ValueObject.value.equals(""))
				{
					lock.wait();
				}
				System.out.println("the value of get is: " + ValueObject.value);
				ValueObject.value = "";
				lock.notify();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
