package com.leon.artofpattern.template.execrise;

public class AccessPoolSql extends SQLOperator
{

	@Override
	public void connSql()
	{
		System.out.println("access pool conn sql");
	}

	@Override
	public void openSql()
	{
		System.out.println("access pool open sql");
	}

	@Override
	public void operateSql(boolean select)
	{
		System.out.println("access pool " + (select ? "select" : "update") + " sql");
	}

	@Override
	public void closeSql()
	{
		System.out.println("access pool close sql");
	}

}
