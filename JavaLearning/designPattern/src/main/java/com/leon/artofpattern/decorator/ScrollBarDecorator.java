package com.leon.artofpattern.decorator;

public class ScrollBarDecorator extends ComponentDecorator
{

	public ScrollBarDecorator(Component component)
	{
		super(component);
	}

	@Override
	public void display()
	{
		super.display();
		this.setScrollBar();
	}

	private void setScrollBar()
	{
		System.out.println("add scrollbar");
	}
}
