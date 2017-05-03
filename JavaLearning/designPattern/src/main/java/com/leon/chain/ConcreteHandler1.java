package com.leon.chain;

public class ConcreteHandler1 extends Handler
{

	@Override
	public void handleRequest(int request)
	{
		if (request > 0 && request < 10)
		{
			System.out.println("handler1处理请求" + request);
		}
		else if (this.successor != null)
		{
			this.successor.handleRequest(request);
		}
	}

}
