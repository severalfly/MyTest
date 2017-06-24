package com.leon.artofpattern.state;

public class OverdraftState extends AccountState
{

	public OverdraftState(Account acc)
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
		this.acc.setBalance(this.acc.getBalance() - amount);
		statecheck();

	}

	@Override
	public void computeInterest()
	{
		System.out.println("start to comput interest");
	}

	@Override
	public void statecheck()
	{
		if (this.acc.getBalance() > 0)
		{
			this.acc.setState(new NormalState(this.acc));
		}
		else if (this.acc.getBalance() == -2000)
		{
			this.acc.setState(new RestrictedState(this.acc));
		}
		else if (this.acc.getBalance() < -2000)
		{
			System.out.println("操作受限");
		}
	}

}
