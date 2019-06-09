package com.leon.abstractFactory;

public class AccessDepartment implements IDepartment
{

	public void insert(Department department)
	{
		System.out.println("insert into access a department");
	}

	public Department getDepartment(String name)
	{
		System.out.println("get a department from access");
		return null;
	}

}
