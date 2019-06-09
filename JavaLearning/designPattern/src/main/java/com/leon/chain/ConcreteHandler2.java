package com.leon.chain;

public class ConcreteHandler2 extends Handler
{

	@Override
	public void handleRequest(int request)
	{
		if (request >= 10 && request < 20)
		{
			System.out.println("handler2处理请求" + request);
		}
		else if (this.successor != null)
		{
			this.successor.handleRequest(request);
		}
	}

}
