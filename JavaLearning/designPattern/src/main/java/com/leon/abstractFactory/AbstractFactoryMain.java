package com.leon.abstractFactory;

public class AbstractFactoryMain
{
	public static void main(String[] args)
	{
		User user = new User();
		Department dept = new Department();

		IUser iu = DataAccess.createUser();
		iu.insert(user);
		iu.getUser(1);

		IDepartment department = DataAccess.createDepartment();
		department.insert(dept);
		department.getDepartment("le");
	}
}
