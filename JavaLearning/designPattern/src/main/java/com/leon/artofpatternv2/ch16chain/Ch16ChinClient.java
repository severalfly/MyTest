package com.leon.artofpatternv2.ch16chain;

import lombok.Getter;
import lombok.Setter;

public class Ch16ChinClient
{
	public static void main(String[] args)
	{
		Approver zwj = new Director("zwj");
		Approver approver = new VicePresident("yg");
		Approver president = new President("gj");
		Approver meeting = new Congress("dsh");

		zwj.setSuccessor(approver);
		approver.setSuccessor(president);
		president.setSuccessor(meeting);

		PurchaseRequest pr1 = new PurchaseRequest(1001, 1001, "购买1");
		PurchaseRequest pr2 = new PurchaseRequest(10001, 1001, "购买2");
		PurchaseRequest pr3 = new PurchaseRequest(100001, 10001, "购买3");
		PurchaseRequest pr4 = new PurchaseRequest(1000001, 100001, "购买4");
		zwj.processRequest(pr1);
		zwj.processRequest(pr2);
		zwj.processRequest(pr3);
		zwj.processRequest(pr4);
	}
}

@Setter
@Getter
class PurchaseRequest
{
	private double amount;
	private int number;
	private String purpose;

	public PurchaseRequest(double amount, int number, String purpose)
	{
		this.amount = amount;
		this.number = number;
		this.purpose = purpose;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("采购单: ");
		sb.append(this.number);
		sb.append(", 金额: ");
		sb.append(this.amount);
		sb.append("元，采购目的: ");
		sb.append(this.purpose);
		sb.append(".");
		return sb.toString();
	}
}

@Setter
@Getter
abstract class Approver
{
	protected Approver successor; // 持有一个后继对象
	protected String name;

	public Approver(String name)
	{
		this.name = name;
	}

	public abstract void processRequest(PurchaseRequest request);
}

class Director extends Approver
{

	public Director(String name)
	{
		super(name);
	}

	@Override
	public void processRequest(PurchaseRequest request)
	{
		if (request.getAmount() < 5000)
		{
			System.out.println(this.getClass().getSimpleName() + " 审批" + request.toString());
		}
		else
		{
			this.successor.processRequest(request);
		}
	}
}

class VicePresident extends Approver
{

	public VicePresident(String name)
	{
		super(name);
	}

	@Override
	public void processRequest(PurchaseRequest request)
	{
		if (request.getAmount() < 50000)
		{
			System.out.println(this.getClass().getSimpleName() + " 审批" + request.toString());
		}
		else
		{
			this.successor.processRequest(request);
		}
	}
}

class President extends Approver
{

	public President(String name)
	{
		super(name);
	}

	@Override
	public void processRequest(PurchaseRequest request)
	{
		if (request.getAmount() < 500000)
		{
			System.out.println(this.getClass().getSimpleName() + " 审批" + request.toString());
		}
		else
		{
			this.successor.processRequest(request);
		}
	}
}

class Congress extends Approver
{

	public Congress(String name)
	{
		super(name);
	}

	@Override
	public void processRequest(PurchaseRequest request)
	{
		System.out.println(this.getClass().getSimpleName() + " 审批" + request.toString());
	}
}
