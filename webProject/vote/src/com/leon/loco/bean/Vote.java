package com.leon.loco.bean;

public class Vote
{
	private int voteID;
	private String voteName;
	private int channelID;

	public int getVoteID()
	{
		return this.voteID;
	}
	public void setVoteID(int voteID)
	{
		this.voteID = voteID;
	}

	public String getVoteName()
	{
		return this.voteName;
	}
	public void setVoteName(String voteName)
	{
		this.voteName = voteName;
	}

	public int getChannelID()
	{
		return this.channelID;
	}
	public void setChannelID(int channelID)
	{
		this.channelID = channelID;
	}
}