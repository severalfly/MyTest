package com.leon.state;

public class ForennoState extends State
{
	// 9点上班开始
	@Override
	public void writeProgram(Work w)
	{
		if (w.getHour() < 12)
		{
			System.out.println("当前时间" + w.getHour() + "点 上午工作，精神百倍");
		}
		else
		{
			w.setState(new NoonState());
			w.writeProgram();
		}
	}
}
