package com.leon.loco.bean;
import java.util.Date;


public class Message
{
	private int messageID;
	private String messageTitle;
	private String messageContent;
	private int employeeID;
	private Date publishTime;

	public int getEmployeeID()
	{
		return this.employeeID;
	}
	public void setEmployeeID(int employeeID)
	{
		this.employeeID = employeeID;
	}

	public int getMessageID()
	{
		return this.messageID;
	}
	public void setMessageID(int messageID)
	{
		this.messageID = messageID;
	}
	public String getMessageTitle()
	{
		return this.messageTitle;
	}
	public void setMessageTitle(String messageTitle)
	{
		this.messageTitle = messageTitle;
	}

	public String getMessageContent()
	{
		return this.messageContent;
	}
	public void setMessageContent(String messageContent)
	{
		this.messageContent = messageContent;
	}

	public Date getPublishTime()
	{
		return this.publishTime;
	}
	public void setPublishTime(Date publishTime)
	{
		this.publishTime = publishTime;
	}

	
}