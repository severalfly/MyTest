package com.leon.artofpattern.chainRespons.exercise;

public class Manager extends LeaveApprove
{

	public Manager(String name)
	{
		super(name);
	}

	@Override
	public void process(Leave leave)
	{
		if (leave.getDay() < 10)
		{
			System.out.println("经理：" + this.name + "审批: " + leave);
		}
		else
		{
			this.successor.process(leave);
		}
	}

}
