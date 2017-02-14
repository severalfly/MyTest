package com.leon.loco.dao;

import java.util.List;


import com.leon.loco.bean.VoteOption;


public interface VoteOptionDAO
{
	public int addVoteOption(VoteOption voteOption);
	public List<VoteOption> findVoteOptionByVoteID(int VoteID);
	public int deleteVoteByID(int voteID);
}