package com.leon.wechart.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leon.wechart.AbstractAction;
import com.leon.wechart.schedule.test.CodeCalWorker;
import com.leon.wechart.util.HttpUtil;

public class CodeAction extends AbstractAction
{
	private static Logger logger = LoggerFactory.getLogger(WechartAction.class);

	@Action(value = "/codettt")
	public void codettt()
	{
		logger.info(HttpUtil.getParam(ServletActionContext.getRequest().getParameterMap()));
		new CodeCalWorker().start();
	}
}
