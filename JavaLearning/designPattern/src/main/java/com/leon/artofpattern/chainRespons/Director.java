package com.leon.artofpattern.chainRespons;

// 主任类
public class Director extends Approver
{

	public Director(String name)
	{
		super(name);
	}

	@Override
	public void processRequest(PurchaseRequest request)
	{
		if (request.getAmount() < 50000)
		{
			// 自己能够处理的
			System.out.println("主任" + this.name + "审批" + request);
		}
		else
		{
			// 不能处理的
			this.successor.processRequest(request);
		}
	}

}
