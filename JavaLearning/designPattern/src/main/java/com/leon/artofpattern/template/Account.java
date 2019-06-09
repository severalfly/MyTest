package com.leon.artofpattern.template;

public abstract class Account
{
	public boolean validate(String account, String passwd)
	{
		System.out.println("account: " + account + ", passwd: " + passwd);
		if (account.equals("leon") && passwd.equals("12345"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public abstract void calculateInterest();

	public void display()
	{
		System.out.println("display interest");
	}

	public void handle(String account, String passwd)
	{
		if (!validate(account, passwd))
		{
			System.out.println("error account or passwd");
			return;
		}
		calculateInterest();
		display();
	}
}
