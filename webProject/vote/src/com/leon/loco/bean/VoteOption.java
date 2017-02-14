package com.leon.loco.bean;


public class VoteOption
{
	private int voteOptionID;
	private int voteID;
	private String voteOptionName;
	private int ticketNum;

	public int getVoteOptionID()
	{
		return this.voteOptionID;
	}
	public void setVoteOptionID(int voteOptionID)
	{
		this.voteOptionID = voteOptionID;
	}

	public int getVoteID()
	{
		return this.voteID;
	}
	public void setVoteID(int voteID)
	{
		this.voteID = voteID;
	}

	public String getVoteOptionName()
	{
		return this.voteOptionName;
	}
	public void setVoteOptionName(String voteOptionName)
	{
		this.voteOptionName = voteOptionName;
	}

	public int getTicketNum()
	{
		return this.ticketNum;
	}
	public void setTicketNum(int ticketNum)
	{
		this.ticketNum = ticketNum;
	}

}