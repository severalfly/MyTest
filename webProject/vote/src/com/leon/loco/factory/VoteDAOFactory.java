package com.leon.loco.factory;

import com.leon.loco.dao.VoteDAO;
import com.leon.loco.daoImpl.VoteDAOImpl;


public class VoteDAOFactory
{
	public static VoteDAO getVoteDAOInstance()
	{
		return new VoteDAOImpl();
	}
}