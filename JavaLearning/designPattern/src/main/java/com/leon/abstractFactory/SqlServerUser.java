package com.leon.abstractFactory;

class SqlServerUser implements IUser
{
	public void insert(User user)
	{
		System.out.println("sql server insert user");
	}

	public User getUser(int id)
	{
		System.out.println("get user from sql server");
		return null;
	}
}
