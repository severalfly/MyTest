package com.leon.loco.bean;

import java.util.List;

import com.leon.loco.bean.Vote;
import com.leon.loco.bean.VoteOption;

public class VoteResult
{
	private Vote vote;
	private List<VoteOption> voteOptions;

	public Vote getVote()
	{
		return this.vote;
	}
	public void setVote(Vote vote)
	{
		this.vote = vote;
	}

	public List<VoteOption> getVoteOptions()
	{
		return this.voteOptions;
	}
	public void setVoteOptions(List<VoteOption> voteOptions)
	{
		this.voteOptions = voteOptions;
	}
}