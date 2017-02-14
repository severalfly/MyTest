import java.sql.*;
public class ConnMysql
{
	public static void main(String[] args) throws Exception {
		// 1. get  Driver
		Class.forName("com.mysql.jdbc.Driver");
		// 2. use DriverManager to get connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "password");
		System.out.println(conn);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from user;");
		System.out.println(rs);
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
		}
		if(rs != null)
		{
			rs.close();
		}
		if(stmt != null)
		{
			stmt.close();
		}
		if(conn != null)
		{
			conn.close();
		}
	}
}