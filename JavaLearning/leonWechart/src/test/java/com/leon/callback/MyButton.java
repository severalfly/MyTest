package com.leon.callback;

public class MyButton
{
	private MyLisener lisener;

	public MyButton()
	{
	}

	public MyButton(MyLisener lisener)
	{
		super();
		this.lisener = lisener;
	}

	public void onclick()
	{
		this.lisener.onclick();
	}

	public MyLisener getLisener()
	{
		return this.lisener;
	}

	public void setLisener(MyLisener lisener)
	{
		this.lisener = lisener;
	}

}
