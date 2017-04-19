package org.ch3.stack_2_new;

public class Runn
{
	public static void main(String[] args)
	{

		MyStack stack = new MyStack();
		P p = new P(stack);
		C c = new C(stack);
		C c1 = new C(stack);
		C c2 = new C(stack);
		C c3 = new C(stack);
		C c4 = new C(stack);
		P_Thread pThread = new P_Thread(p);
		C_Thread cThread = new C_Thread(c);
		C_Thread cThread1 = new C_Thread(c);
		C_Thread cThread2 = new C_Thread(c);
		C_Thread cThread3 = new C_Thread(c);
		C_Thread cThread4 = new C_Thread(c);
		pThread.start();
		cThread.start();
		cThread1.start();
		cThread2.start();
		cThread3.start();
		cThread4.start();
	}
}
