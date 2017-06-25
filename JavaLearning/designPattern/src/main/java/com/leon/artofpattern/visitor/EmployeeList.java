package com.leon.artofpattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList
{
	private List<Emploee> list = new ArrayList<Emploee>();

	public void addEmployee(Emploee emploee)
	{
		this.list.add(emploee);
	}

	public void accept(Department handler)
	{
		for (Emploee emploee : this.list)
		{
			emploee.accept(handler);
		}
	}
}
