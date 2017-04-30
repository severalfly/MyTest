package com.leon.abstractFactory;

class SqlServerFactory implements IFactory
{

	public IUser createUser()
	{
		return new SqlServerUser();
	}

}