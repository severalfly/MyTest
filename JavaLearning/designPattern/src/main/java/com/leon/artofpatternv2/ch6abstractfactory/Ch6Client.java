package com.leon.artofpatternv2.ch6abstractfactory;

import com.leon.util.XMLUtil;

public class Ch6Client
{
	public static void main(String[] args)
	{
		SkinFactory skinFactory = (SkinFactory) XMLUtil.getBean("abstractFactoryMethodv2");
		Button button = skinFactory.createButton();
		TextField textField = skinFactory.createTextField();
		button.display();
		textField.display();
	}
}
