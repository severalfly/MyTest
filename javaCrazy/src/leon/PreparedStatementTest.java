package leon;
import java.io.*;
import java.util.*;
import java.sql.*;
public class PreparedStatementTest
{
	private String driver;
	private String url;
	private String user;
	private String pass;
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;

	public void initParam(String paramFile) throws Exception
	{
		Properties prop = new Properties();
		prop.load(new FileInputStream(paramFile));
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		pass = prop.getProperty("pass");
	}
	public void insertUseStatement() throws Exception
	{
		long start = System.currentTimeMillis();
		try
		{
			stmt = conn.createStatement();
			for (int i=0; i < 100; i++) {
				stmt.executeUpdate("insert into my_test(username) values('name" + i + "');");
			}
			System.out.println("use statement cost:" + (System.currentTimeMillis() - start));
		}
		finally
		{
			if(stmt != null)
			{
				stmt.close();
			}
		}
	}

	public void insertUsePreparedStatement() throws Exception
	{
		long start = System.currentTimeMillis();
		try
		{
			pstmt = conn.prepareStatement("insert into my_test(username) value(?);");
			for (int i = 0; i<100; i++) {
				pstmt.setString(1,"prepars Name " + i);
				pstmt.executeUpdate();
			}
			System.out.println("prepared cost " + (System.currentTimeMillis() - start));
		}
		finally
		{
			if(pstmt != null)
			{
				pstmt.close();
			}
		}
	}

	public void getConn() throws Exception
	{
		if(conn == null)
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pass);
		}
	}
	public void closeConn() throws Exception
	{
		if(conn != null)
		{
			conn.close();
		}
	}

	public static void main(String[] args) throws Exception{
		PreparedStatementTest pst = new PreparedStatementTest();
		pst.initParam("mysql.ini");
		pst.getConn();
		pst.insertUseStatement();
		pst.insertUsePreparedStatement();
		pst.closeConn();
	}
}