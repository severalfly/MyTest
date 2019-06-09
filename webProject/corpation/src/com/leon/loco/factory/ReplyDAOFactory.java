package com.leon.loco.factory;

import com.leon.loco.dao.ReplyDAO;
import com.leon.loco.daoImpl.ReplyDAOImpl;

public class ReplyDAOFactory
{
	public static ReplyDAO getReplyDAOInstance()
	{
		return new ReplyDAOImpl();
	}
}