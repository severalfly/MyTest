package com.leon.decorator.result;

public class Finery extends Person
{
	protected Person component;

	public void decorator(Person component)
	{
		this.component = component;
	}

	@Override
	public void show()
	{
		if (this.component != null)
		{
			this.component.show();
		}
	}
}
