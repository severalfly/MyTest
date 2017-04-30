package com.leon.abstractFactory;

public class SqlServerDepartment implements IDepartment
{

	public void insert(Department department)
	{
		System.out.println("insert department to sqlserver");
	}

	public Department getDepartment(String name)
	{
		System.out.println("get department from sqlserver");
		return null;
	}

}
