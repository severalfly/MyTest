package org.ch3.p_r_allwaitfix;

public class Runn
{
	public static void main(String[] args) throws InterruptedException
	{
		String lock = new String("");
		P p = new P(lock);
		C c = new C(lock);
		ThreadP[] pTs = new ThreadP[2];
		ThreadC[] cTs = new ThreadC[2];
		for (int i = 0; i < 2; i++)
		{
			pTs[i] = new ThreadP(p);
			pTs[i].setName("productor " + (i + 1));

			cTs[i] = new ThreadC(c);
			cTs[i].setName("consumer " + (i + 1));
			pTs[i].start();
			cTs[i].start();

		}
		Thread.sleep(5000);
		Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
		Thread.currentThread().getThreadGroup().enumerate(threadArray);
		for (int i = 0; i < threadArray.length; i++)
		{
			System.out.println(threadArray[i].getName() + " " + threadArray[i].getState());
		}
	}
}
