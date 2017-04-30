package com.leon.state;

public class EvenintState extends State
{

	@Override
	public void writeProgram(Work w)
	{
		if (w.isFinish())
		{
			w.setState(new RestState());
			w.writeProgram();
		}
		else
		{
			if (w.getHour() < 21)
			{
				System.out.println("当前时间" + w.getHour() + "点 加班哦，疲累之极");
			}
			else
			{
				w.setState(new SleepingState());
				w.writeProgram();
			}
		}
	}

}
