package org.ch3.p_r_allwaitfix;

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
				while (ValueObject.value.equals(""))
				{
					System.out.println("consume " + Thread.currentThread().getName() + " waiting!");
					lock.wait();
				}
				System.out.println("consume " + Thread.currentThread().getName() + " runable");
				ValueObject.value = "";
				lock.notifyAll();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
