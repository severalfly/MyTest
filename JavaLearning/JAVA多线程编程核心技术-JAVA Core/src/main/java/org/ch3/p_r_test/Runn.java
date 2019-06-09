package org.ch3.p_r_test;

public class Runn
{
	public static void main(String[] args)
	{
		String lock = new String("");
		P p = new P(lock);
		C c = new C(lock);
		ThreadP pThread = new ThreadP(p);
		ThreadC cThread = new ThreadC(c);
		pThread.start();
		cThread.start();
	}
}
