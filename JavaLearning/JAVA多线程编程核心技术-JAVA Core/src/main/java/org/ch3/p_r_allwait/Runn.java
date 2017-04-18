package org.ch3.p_r_allwait;

public class Runn
{
	public static void main(String[] args)
	{
		String lock = new String("");
		P p = new P(lock);
		C c = new C(lock);
		ThreadP[] pTs = new ThreadP[2];
		ThreadC[] cTs = new ThreadC[2];
		for (int i = 0; i < 2; i++)
		{
			pTs[i] = new ThreadP(p);
			pTs[i].start();
		}
		ThreadP pThread = new ThreadP(p);
		ThreadC cThread = new ThreadC(c);
		pThread.start();
		cThread.start();
	}
}
