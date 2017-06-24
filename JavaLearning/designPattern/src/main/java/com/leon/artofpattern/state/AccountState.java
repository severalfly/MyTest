package com.leon.artofpattern.state;

public abstract class AccountState
{
	protected Account acc;

	public AccountState(Account acc)
	{
		super();
		this.acc = acc;
	}

	public abstract void deposit(double amount);

	public abstract void withdraw(double amount);

	public abstract void computeInterest();

	public abstract void statecheck();
}
