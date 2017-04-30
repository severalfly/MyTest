package com.leon.abstractFactory;

public class DataAccess
{
	private static db d = db.SqlServer;

	public static IUser createUser()
	{
		IUser result = null;
		try
		{
			result = (IUser) Class.forName(d.toString()).newInstance();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if (result != null)
		{
			return result;
		}
		switch (d)
		{
		case SqlServer:
			result = new SqlServerUser();
			break;
		case Access:
			result = new Accessuser();
			break;
		default:
			break;
		}
		return result;
	}

	public static IDepartment createDepartment()
	{
		IDepartment result = null;
		try
		{
			result = (IDepartment) Class.forName(d.toString()).newInstance();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if (result != null)
		{
			return result;
		}
		switch (d)
		{
		case SqlServer:
			result = new SqlServerDepartment();
			break;
		case Access:
			result = new AccessDepartment();
			break;
		default:
			break;
		}
		return result;

	}
}

enum db
{
	SqlServer, Access
}