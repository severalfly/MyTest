package com.leon.wechart;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class Initializer implements ApplicationListener
{

	@Override
	public void onApplicationEvent(ApplicationEvent arg0)
	{
		System.out.println("start");
	}

}
