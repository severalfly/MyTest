package com.leon.artofpattern.visitor;

public class HRDepartment extends Department
{

	@Override
	public void visit(FullTimeEmployee employee)
	{
		int workTime = employee.getWorkTime();
		System.out.println("full time employee: " + employee.getName() + " real work time is: " + workTime + ".");
		if (workTime > 40)
		{
			System.out.println(" add work time: " + (workTime - 40));
		}
		else if (workTime < 40)
		{
			System.out.println("; leave time: " + (40 - workTime));
		}
	}

	@Override
	public void visit(ParttimeEmployee employee)
	{
		System.out.println("part time employee: " + employee.getName() + " real work time: " + employee.getWorkTime());
	}

}
