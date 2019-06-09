package com.leon.state;

public class Work
{
	private State current;
	private double hour;
	private boolean finish = false;

	public Work()
	{
		this.current = new ForennoState();
	}

	public double getHour()
	{
		return hour;
	}

	public void setHour(double hour)
	{
		this.hour = hour;
	}

	public boolean isFinish()
	{
		return finish;
	}

	public void setFinish(boolean finish)
	{
		this.finish = finish;
	}

	public void setState(State s)
	{
		this.current = s;
	}

	public void writeProgram()
	{
		this.current.writeProgram(this);
	}
}
