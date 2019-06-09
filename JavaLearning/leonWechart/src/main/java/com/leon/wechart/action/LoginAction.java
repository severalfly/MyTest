package com.leon.wechart.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport
{

	public String Name;
	public int Age;

	public String getResult()
	{
		return Result;
	}

	public void setResult(String result)
	{
		Result = result;
	}

	public String Result;

	public String getName()
	{
		return Name;
	}

	public void setName(String name)
	{
		Name = name;
	}

	public int getAge()
	{
		return Age;
	}

	public void setAge(int age)
	{
		Age = age;
	}

	@Override
	public String execute() throws Exception
	{
		this.setResult("name:" + Name);
		this.setResult(this.getResult() + "&age:" + String.valueOf(Age));
		return "success";
	}

}
