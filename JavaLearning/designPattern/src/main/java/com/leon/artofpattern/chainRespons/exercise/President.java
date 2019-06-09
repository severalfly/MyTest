package com.leon.artofpattern.chainRespons.exercise;

public class President extends LeaveApprove
{

	public President(String name)
	{
		super(name);
	}

	@Override
	public void process(Leave leave)
	{
		if (leave.getDay() < 30)
		{
			System.out.println("总经理：" + this.name + "审批: " + leave);
		}
		else
		{
			System.out.println(leave + " 不予通过");
		}
	}

}
