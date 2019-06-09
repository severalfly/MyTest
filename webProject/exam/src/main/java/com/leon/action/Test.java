package com.leon.action;


import com.opensymphony.xwork2.ActionSupport;

public class Test extends ActionSupport
{
	@Override
	public String execute() throws Exception
	{
		System.out.println("test");
		return this.SUCCESS;
	}
}