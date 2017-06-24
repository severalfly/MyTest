package com.leon.artofpattern.state;

public class Account
{
	private AccountState state;
	private String owner;
	private double balance = 0;

	public Account(String owner, double balance)
	{
		super();
		this.state = new NormalState(this);
		this.owner = owner;
		this.balance = balance;

		System.out.println(this.owner + " start an account, the initalize amount is: " + this.balance);
		System.out.println("--------------------------------");
	}

	public AccountState getState()
	{
		return this.state;
	}

	public void setState(AccountState state)
	{
		this.state = state;
	}

	public double getBalance()
	{
		return this.balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	public void deposit(double amount)
	{
		System.out.println(this.owner + " deposit: " + amount);
		this.state.deposit(amount);
		System.out.println("the balance is: " + this.balance);
		System.out.println("the state of the account is: " + this.state.getClass().getName());
		System.out.println("--------------------");

	}

	public void withdraw(double amount)
	{
		System.out.println(this.owner + " withdraw: " + amount);
		this.state.withdraw(amount);
		System.out.println("the balance is: " + this.balance);
		System.out.println("the state of the account is: " + this.state.getClass().getName());
		System.out.println("---------------------");
	}

	public void computeInsterest()
	{
		this.state.computeInterest();
	}
}
