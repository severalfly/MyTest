package com.leon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection
{
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/db_examsystem";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "password";

	public static Connection getConnection()
	{
		Connection conn = null;
		try
		{
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		}
		catch (Exception e) 
		{
			e.printStackTrace();	
		}
		return conn;
	}

	public static void close(Connection conn)
	{
		if(null != conn)
		{
			try
			{
				conn.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}

	public static void close(PreparedStatement pStat)
	{
		if(null != pStat)
		{
			try
			{
				pStat.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs)
	{
		if(null != rs)
		{
			try
			{
				rs.close();
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}