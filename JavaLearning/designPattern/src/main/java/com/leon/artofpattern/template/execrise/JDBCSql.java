package com.leon.artofpattern.template.execrise;

public class JDBCSql extends SQLOperator
{

	@Override
	public void connSql()
	{
		System.out.println("jdbc conn sql");
	}

	@Override
	public void openSql()
	{
		System.out.println("jdbc open sql");
	}

	@Override
	public void operateSql(boolean select)
	{
		System.out.println("jdbc " + (select ? "select" : "update") + " sql");
	}

	@Override
	public void closeSql()
	{
		System.out.println("jdbc close sql");
	}

}
