package com.leon.artofpattern.decorator;

public class BlackBorderDecorator extends ComponentDecorator
{

	public BlackBorderDecorator(Component component)
	{
		super(component);
	}

	@Override
	public void display()
	{
		super.display();
		this.setBlackBorder();
	}

	private void setBlackBorder()
	{
		System.out.println("add black border");
	}
}
