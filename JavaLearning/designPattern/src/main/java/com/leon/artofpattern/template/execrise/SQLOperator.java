package com.leon.artofpattern.template.execrise;

public abstract class SQLOperator
{

	public abstract void connSql();

	public abstract void openSql();

	/**
	 * 
	 * @param select 是否为查询操作 true/false
	 */
	public abstract void operateSql(boolean select);

	public abstract void closeSql();

	public void handle(boolean select)
	{
		connSql();
		openSql();
		operateSql(select);
		closeSql();
	}
}
