package com.leon.chain;

public class ConcreteHandler3 extends Handler
{

	@Override
	public void handleRequest(int request)
	{
		if(request >=20)
		{
			System.out.println("handler3开始处理了" + request);
		}
	}

}
