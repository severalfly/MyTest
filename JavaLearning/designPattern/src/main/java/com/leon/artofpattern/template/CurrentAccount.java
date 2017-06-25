package com.leon.artofpattern.template;

public class CurrentAccount extends Account
{

	@Override
	public void calculateInterest()
	{
		System.out.println("current account interest calculate");
	}

}
