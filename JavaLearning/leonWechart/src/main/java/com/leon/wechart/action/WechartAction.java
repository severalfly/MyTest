package com.leon.wechart.action;

import com.opensymphony.xwork2.ActionSupport;

public class WechartAction extends ActionSupport
{
	@Override
	public String execute() throws Exception
	{
		System.out.println("test");
		return SUCCESS;
	}
}
