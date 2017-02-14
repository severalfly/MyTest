package com.leon.loco.factory;

import com.leon.loco.dao.EmployeeDAO;
import com.leon.loco.daoImpl.EmployeeDAOImpl;

public class EmployeeDAOFactory
{
	public static EmployeeDAO getEmployeeDAOInstance()
	{
		return new EmployeeDAOImpl();
	}
}