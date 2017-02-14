import java.sql.*;
import java.util.*;
import java.io.*;
public class ExecuteDDL
{
	private String driver;
	private String url;
	private String user;
	private String pass;

	public void initParam(String paramFile) throws Exception
	{
		Properties prop = new Properties();
		prop.load(new FileInputStream(paramFile));
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		pass = prop.getProperty("pass");
	}

	public void createTable(String sql) throws Exception
	{
		Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}
		finally
		{
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

	public static void main(String[] args) throws Exception{
		ExecuteDDL ed = new ExecuteDDL();
		ed.initParam("mysql.ini");
		ed.createTable("create table jdbc_test (jdbc_id int auto_increment primary key, jdbc_name varchar(250));");
		System.out.println("Sucess");
	}
}