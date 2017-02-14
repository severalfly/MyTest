package com.leon.loco.factory;

import com.leon.loco.dao.MessageDAO;
import com.leon.loco.daoImpl.MessageDAOImpl;

public class MessageDAOFactory
{
	public static MessageDAO getMessageDAOInstance()
	{
		return new MessageDAOImpl();
	}
}