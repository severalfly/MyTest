package com.leon.loco.action;

import com.opensymphony.xwork2.ActionSupport;

import com.leon.loco.bean.Vote;
import com.leon.loco.bean.VoteOption;

import com.leon.loco.dao.VoteDAO;
import com.leon.loco.dao.VoteOptionDAO;

import com.leon.loco.factory.VoteDAOFactory;
import com.leon.loco.factory.VoteOptionDAOFactory;

public class addVote extends ActionSupport
{
	private int channel;
	private String voteName;
	private String[] voteOption;
	public String execute() throws Exception
	{
		System.out.println(this.channel);
		System.out.println(this.voteName);

		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
		VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();

		Vote vote = new Vote();
		vote.setChannelID(this.channel);
		vote.setVoteName(this.voteName);
		voteDAO.addVote(vote);
		int voteID = voteDAO.findVoteIDByName(this.voteName);
		for (String voteOptionName : voteOption) {
			VoteOption vp = new VoteOption();
			vp.setVoteID(voteID);
			vp.setVoteOptionName(voteOptionName);
			voteOptionDAO.addVoteOption(vp);
			
		}
		return this.SUCCESS;
	}

	public int getChannel()
	{
		return this.channel;
	}
	public void setChannel(int channel)
	{
		this.channel = channel;
	}

	public String getVoteName()
	{
		return this.voteName;
	}
	public void setVoteName(String voteName)
	{
		this.voteName = voteName;
	}

	public String[] getVoteOption()
	{
		return this.voteOption;
	}
	public void setVoteOption(String[] voteOption)
	{
		this.voteOption = voteOption;
	}
}