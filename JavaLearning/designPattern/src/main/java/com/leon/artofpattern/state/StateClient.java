package com.leon.artofpattern.state;

public class StateClient
{
	public static void main(String[] args)
	{
		Account acc = new Account("leon", 0.0f);
		acc.deposit(1000);
		acc.withdraw(2000);
		acc.deposit(3000);
		acc.withdraw(4000);
		acc.withdraw(1000);
		acc.computeInsterest();
	}
}
