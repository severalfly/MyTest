package org.ch2.synNotExtends;

public class Main
{
	synchronized public void serviceMethod()
	{
		try
		{
			System.out.println("int main ��һ�� sleep begin threadNmae =" + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("int main ��һ�� sleep end threadNmae =" + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());

		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
