package com.leon.abstractFactory;

class Accessuser implements IUser
{

	public void insert(User user)
	{
		System.out.println("access insert user");
	}

	public User getUser(int id)
	{
		System.out.println("get user from access");
		return null;
	}

}
