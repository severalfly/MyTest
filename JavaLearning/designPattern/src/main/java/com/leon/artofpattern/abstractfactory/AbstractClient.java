package com.leon.artofpattern.abstractfactory;

import com.leon.util.XMLUtil;

public class AbstractClient
{
	public static void main(String[] args)
	{
		SkinFactory factory = (SkinFactory) XMLUtil.getBean("abstractFactoryMethod");
		Button bt = factory.createButton();
		TextField tf = factory.createTextField();
		ComboBox cb = factory.createComboBox();
		bt.display();
		tf.display();
		cb.display();
	}
}
