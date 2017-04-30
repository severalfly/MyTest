package com.leon.abstractFactory;

class AccessFactory implements IFactory
{

	public IUser createUser()
	{
		return new Accessuser();
	}

}