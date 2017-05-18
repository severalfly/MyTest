package com.leon.wechart.action;

import org.apache.struts2.convention.annotation.Action;

import com.leon.wechart.service.WeatherService;
import com.opensymphony.xwork2.ActionSupport;

public class WechartAction extends ActionSupport
{
	@Override
	public String execute() throws Exception
	{
		System.out.println(WeatherService.getWeather("武汉"));
		System.out.println("test");
		return SUCCESS;
	}

	@Action(value = "/test")
	public void test()
	{
		System.out.println("testtest");
	}
}
