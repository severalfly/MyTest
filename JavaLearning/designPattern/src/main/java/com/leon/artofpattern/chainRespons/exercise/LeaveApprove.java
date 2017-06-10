package com.leon.artofpattern.chainRespons.exercise;

public abstract class LeaveApprove
{
	protected LeaveApprove successor;
	protected String name;

	public LeaveApprove(String name)
	{
		super();
		this.name = name;
	}

	public LeaveApprove getSuccessor()
	{
		return this.successor;
	}

	public void setSuccessor(LeaveApprove successor)
	{
		this.successor = successor;
	}

	public abstract void process(Leave leave);
}
