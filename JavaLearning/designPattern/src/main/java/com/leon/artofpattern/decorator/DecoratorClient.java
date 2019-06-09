package com.leon.artofpattern.decorator;

public class DecoratorClient
{
	public static void main(String[] args)
	{
		Component component, componentSB;
		component = new Window();

		// 使用构造函数确定构造关系；在大话设计模式中，强制指定的
		componentSB = new ScrollBarDecorator(component);

		Component componentBB = new BlackBorderDecorator(componentSB);

		componentBB.display();
	}
}
