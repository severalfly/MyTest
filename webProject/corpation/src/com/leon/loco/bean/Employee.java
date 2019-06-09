package com.leon.loco.bean;

import java.util.Date;

public class Employee
{
	private int employeeID;
	private String employeeName;
	private Date joinTime;
	private String password;
	private boolean isLead;

	public int getEmployeeID()
	{
		return this.employeeID;
	}
	public void setEmployeeID(int employeeID)
	{
		this.employeeID = employeeID;
	}
	public String getEmployeeName()
	{
		return this.employeeName;
	}
	public void setEmployeeName(String employeeName)
	{
		this.employeeName = employeeName;
	}

	public Date getJoinTime()
	{
		return this.joinTime;
	}
	public void setJoinTime(Date joinTime)
	{
		this.joinTime = joinTime;
	}

	public String getPassword()
	{
		return this.password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}

	public boolean getIsLead()
	{
		return this.isLead;
	}
	public void setIsLead(boolean isLead)
	{
		this.isLead = isLead;
	}

}