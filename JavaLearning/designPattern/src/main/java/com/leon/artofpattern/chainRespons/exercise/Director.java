package com.leon.artofpattern.chainRespons.exercise;

public class Director extends LeaveApprove
{

	public Director(String name)
	{
		super(name);
	}

	@Override
	public void process(Leave leave)
	{
		if (leave.getDay() < 3)
		{
			System.out.println("主任：" + this.name + "审批: " + leave);
		}
		else
		{
			this.successor.process(leave);
		}
	}

}
