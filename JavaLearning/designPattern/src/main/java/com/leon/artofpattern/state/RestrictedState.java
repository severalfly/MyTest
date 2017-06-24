package com.leon.artofpattern.state;

public class RestrictedState extends AccountState
{

	public RestrictedState(Account acc)
	{
		super(acc);
	}

	@Override
	public void deposit(double amount)
	{
		this.acc.setBalance(this.acc.getBalance() + amount);
		statecheck();
	}

	@Override
	public void withdraw(double amount)
	{
		System.out.println("failed to with draw");
	}

	@Override
	public void computeInterest()
	{
		System.out.println("start to compute interest");
	}

	@Override
	public void statecheck()
	{
		if (this.acc.getBalance() > 0)
		{
			this.acc.setState(new NormalState(this.acc));
		}
		else if (this.acc.getBalance() > -2000)
		{
			this.acc.setState(new OverdraftState(this.acc));
		}
	}

}
