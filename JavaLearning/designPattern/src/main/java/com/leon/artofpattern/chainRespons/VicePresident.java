package com.leon.artofpattern.chainRespons;

public class VicePresident extends Approver
{

	public VicePresident(String name)
	{
		super(name);
	}

	@Override
	public void processRequest(PurchaseRequest request)
	{
		if (request.getAmount() < 100000)
		{
			// 自己能够处理的
			System.out.println("副董事长" + this.name + "审批" + request);
		}
		else
		{
			// 不能处理的
			this.successor.processRequest(request);
		}
	}

}
