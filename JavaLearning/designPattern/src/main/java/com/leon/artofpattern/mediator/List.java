package com.leon.artofpattern.mediator;

public class List extends Component
{

	@Override
	public void update()
	{
		System.out.println("列表增加一项：张无忌");
	}

	public void select()
	{
		System.out.println("列表选中项：小龙女");
	}

}
