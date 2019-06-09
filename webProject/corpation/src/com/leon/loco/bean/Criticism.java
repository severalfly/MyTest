package com.leon.loco.bean;
import java.util.Date;



public class Criticism
{
	private int criticismID;
	private String criticismContent;
	private int employeeID;
	private Date criticismTime;
	private int messageID;


	public int getEmployeeID()
	{
		return this.employeeID;
	}
	public void setEmployeeID(int employeeID)
	{
		this.employeeID = employeeID;
	}

	public int getCriticismID()
	{
		return this.criticismID;
	}
	public void setCriticismID(int criticismID)
	{
		this.criticismID = criticismID;
	}

	public int getMessageID()
	{
		return this.messageID;
	}
	public void setMessageID(int messageID)
	{
		this.messageID = messageID;
	}

	public String getCriticismContent()
	{
		return this.criticismContent;
	}
	public void setCritisicmContent(String criticismContent)
	{
		this.criticismContent = criticismContent;
	}

	public Date getCriticismTime()
	{
		return this.criticismTime;
	}
	public void setCriticismTime(Date criticismTime)
	{
		this.criticismTime = criticismTime;
	}
}