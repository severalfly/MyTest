package org.ch2.synNotExtends;

public class Sub extends Main
{
	@Override
	public void serviceMethod()
	{

		try
		{
			System.out.println("int sub ��һ�� sleep begin threadNmae =" + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("int sub ��һ�� sleep end threadNmae =" + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
			super.serviceMethod();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

	}
}
