package org.ch3.stack_1;

public class Runn
{
	MyStack stack = new MyStack();
	P p = new P(stack);
	C c = new C(stack);
	P_Thread pThread = new P_Thread(p);
	C_Thread cThread = new C_Thread(c);
}
