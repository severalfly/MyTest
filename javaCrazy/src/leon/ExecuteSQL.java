package leon;
import java.sql.*;
import java.io.*;
import java.util.*;
public class ExecuteSQL
{
	private String driver;
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	public void initParam(String paramFile) throws Exception
	{
		Properties prop = new Properties();
		prop.load(new FileInputStream(paramFile));
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		pass = prop.getProperty("pass");
	}
	public void executeSql(String sql) throws Exception
	{
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
			boolean hasResultSet = stmt.execute(sql);
			if(hasResultSet)
			{
				rs = stmt.getResultSet();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				while(rs.next())
				{
					for(int i= 0; i< columnCount; ++i)
					{
						System.out.print(rs.getString(i+1) + "\t");
					}
					System.out.println();
				}
			}
			else
			{
				System.out.println(sql +" influenced " + stmt.getUpdateCount() + " line");
				
			}
		}
		finally
		{
			if(rs != null)
			{
				rs.close();
			}
			if(stmt != null)
			{
				stmt.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}
	}

	public static void main(String[] args) throws Exception
	{
		ExecuteSQL es = new ExecuteSQL();
		es.initParam("mysql.ini");
		System.out.println("delete");
		es.executeSql("drop table if exists my_test");
		System.out.println("create");
		es.executeSql("create table my_test(username varchar(20));");
		System.out.println("insert");
		es.executeSql("insert into my_test(username) value('ceshi');");
		System.out.println("select ");
		es.executeSql("select * from my_test;");
	}
}