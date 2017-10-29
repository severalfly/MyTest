package com.leon.wechart.interceptor;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LogInterceptor extends AbstractInterceptor
{
	private static final long serialVersionUID = -6589328681383012679L;
	private static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

	@Override
	public String intercept(ActionInvocation invocation) throws Exception
	{
		logger.info(new Date() + " request  ");
		return invocation.invoke();
		//		return Action.SUCCESS;
	}

}
