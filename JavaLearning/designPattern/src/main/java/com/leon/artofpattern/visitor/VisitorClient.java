package com.leon.artofpattern.visitor;

import com.leon.util.XMLUtil;

public class VisitorClient
{

	public static void main(String[] args)
	{
		EmployeeList list = new EmployeeList();
		Emploee fte1 = new FullTimeEmployee("leon", 3200, 45);
		Emploee fte2 = new FullTimeEmployee("severalfly", 2000, 40);
		Emploee fte3 = new FullTimeEmployee("huoli", 2400, 38);
		Emploee pte1 = new ParttimeEmployee("tian", 80, 20);
		Emploee pte2 = new ParttimeEmployee("hui", 60, 18);

		list.addEmployee(fte1);
		list.addEmployee(fte2);
		list.addEmployee(fte3);
		list.addEmployee(pte1);
		list.addEmployee(pte2);

		Department dep = (Department) XMLUtil.getBean("visitorClient");
		list.accept(dep);
	}

}
