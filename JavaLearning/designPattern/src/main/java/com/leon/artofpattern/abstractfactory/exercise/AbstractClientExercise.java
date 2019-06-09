package com.leon.artofpattern.abstractfactory.exercise;

import com.leon.util.XMLUtil;

public class AbstractClientExercise
{
	public static void main(String[] args)
	{
		SmartPhoneFacotry factory = (SmartPhoneFacotry) XMLUtil.getBean("abstractFactoryMethodExercise");
		Operation op = factory.createOperation();
		InterfaceController ic = factory.createInterfaceController();
		op.show();
		ic.show();
	}
}
