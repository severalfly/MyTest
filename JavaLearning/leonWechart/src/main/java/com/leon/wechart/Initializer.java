package com.leon.wechart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Repository;

@Repository
public class Initializer implements ApplicationListener
{
	private static final Logger logger = LoggerFactory.getLogger(Initializer.class);

	@Override
	public void onApplicationEvent(ApplicationEvent arg0)
	{
		System.out.println("start leon");
		logger.info("leonstartup");
	}

}
