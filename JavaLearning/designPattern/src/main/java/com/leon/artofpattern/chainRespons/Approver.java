package com.leon.artofpattern.chainRespons;

public abstract class Approver
{
	// 审批者类
	protected Approver successor;// 定义后继处理对象
	protected String name;

	public Approver(String name)
	{
		super();
		this.name = name;
	}

	public abstract void processRequest(PurchaseRequest request);

	public Approver getSuccessor()
	{
		return this.successor;
	}

	public void setSuccessor(Approver successor)
	{
		this.successor = successor;
	}

}
