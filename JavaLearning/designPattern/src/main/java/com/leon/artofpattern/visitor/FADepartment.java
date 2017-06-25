package com.leon.artofpattern.visitor;

public class FADepartment extends Department
{

	/**
	 * 对正式员工计算工资
	 */
	@Override
	public void visit(FullTimeEmployee employee)
	{
		int workTime = employee.getWorkTime();
		double weekWage = employee.getWeeklyWage();
		if (workTime > 40)
		{
			weekWage = weekWage + (workTime - 40) * 100;
		}
		else if (workTime < 40)
		{
			weekWage = weekWage - (40 - workTime) * 80;
			if (weekWage < 0)
			{
				weekWage = 0;
			}
		}
		System.out.println("full time employee: " + employee.getName() + " real wage is: " + weekWage);
	}

	@Override
	public void visit(ParttimeEmployee employee)
	{
		int workTime = employee.getWorkTime();
		double hourWage = employee.getHourWage();
		System.out.println("parttime employee: " + employee.getName() + " real wage is: " + workTime * hourWage);
	}

}
