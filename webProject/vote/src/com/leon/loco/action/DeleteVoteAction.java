package com.leon.loco.action;

import com.opensymphony.xwork2.ActionSupport;

import com.leon.loco.dao.VoteDAO;
import com.leon.loco.factory.VoteDAOFactory;

import com.leon.loco.dao.VoteOptionDAO;
import com.leon.loco.factory.VoteOptionDAOFactory;

import com.leon.loco.util.ObjectUtils;

public class DeleteVoteAction extends ActionSupport
{
	private int voteID;
	public int getVoteID()
	{
		return this.voteID;
	}
	public void setVoteID(int voteID)
	{
		this.voteID = voteID;
	}

	public String execute()throws Exception
	{
		if (ObjectUtils.getInt(this.voteID) > 0) 
		{
			VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
			VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
			voteOptionDAO.deleteVoteByID(this.voteID);
			voteDAO.deleteVoteByID(this.voteID);	
		}
		return this.SUCCESS;
	}
}