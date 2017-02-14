package com.leon.loco.bean;
import java.util.Date;


public class Reply
{
	private int replyID;
	private String replyContent;
	private int employeeID;
	private Date replyTime;
	private int messageID;

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
	
	public String getReplyContent()
	{
		return this.replyContent;
	}
	public void setReplyContent(String replyContent)
	{
		this.replyContent = replyContent;
	}

	public Date getReplyTime()
	{
		return this.replyTime;
	}
	public void setReplyTime(Date replyTime)
	{
		this.replyTime = replyTime;
	}
}