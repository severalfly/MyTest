package com.leon.artofpatternv2.ch12decorator;

public class Ch12DecoratorClient
{
	public static void main(String[] args)
	{
		// 此处可修改为 TextBox 或者 ListBox
		Component component = new Window();
		Component componentSb = new ScrollBarDecorator(component);

//		componentSb.operate();

		Component componentBd = new BlackBorderDecorator(componentSb);
		componentBd.operate();

	}
}

interface Component
{
	public void operate();
}

class Window implements Component
{
	@Override
	public void operate()
	{
		System.out.println(this.getClass().getSimpleName() + " " + "operate");
	}
}

class TextBox implements Component
{
	@Override
	public void operate()
	{
		System.out.println(this.getClass().getSimpleName() + " " + "operate");
	}
}

class ListBox implements Component
{
	@Override
	public void operate()
	{
		System.out.println(this.getClass().getSimpleName() + " " + "operate");
	}
}

class ComponentDecorator implements Component
{
	private Component component;

	public ComponentDecorator(Component component)
	{
		this.component = component;
	}

	@Override
	public void operate()
	{
		this.component.operate();
	}

	public void display()
	{

	}
}

class ScrollBarDecorator extends ComponentDecorator
{

	public ScrollBarDecorator(Component component)
	{
		super(component);
	}

	@Override
	public void operate()
	{
		setScrollBar();
		super.operate();
	}

	public void setScrollBar()
	{
		System.out.println(this.getClass().getSimpleName() + "  " + " set scroll bar");
	}
}

class BlackBorderDecorator extends ComponentDecorator
{

	public BlackBorderDecorator(Component component)
	{
		super(component);
	}

	@Override
	public void operate()
	{
		setBlackBorder();
		super.operate();
	}

	public void setBlackBorder()
	{
		System.out.println(this.getClass().getSimpleName() + "  " + " set black border");
	}
}
