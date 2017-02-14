package com.leon.loco.factory;

import com.leon.loco.dao.VoteOptionDAO;
import com.leon.loco.daoImpl.VoteOptionDAOImpl;


public class VoteOptionDAOFactory
{
	public static VoteOptionDAO getVoteOptionDAOInstance()
	{
		return new VoteOptionDAOImpl();
	}
}