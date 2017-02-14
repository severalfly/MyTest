package com.leon.loco.dao;

import java.util.List;

import com.leon.loco.bean.Vote;
import com.leon.loco.util.Page;

public interface VoteDAO
{
	public int addVote(Vote vote);
	public Vote findVoteByID(int voteID);
	public Vote findVoteByName(String voteName);
	public int findVoteIDByName(String voteName);
	public int findAllCount();
	public List<Vote> findAllPage(Page page);
	public int deleteVoteByID(int voteID);
	public int findCountByChannelID(int channelID);
	public List<Vote> findVotesByChannelID(Page page, int channelID);
}