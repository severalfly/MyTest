package leon;
import java.io.*;
import java.util.*;
public class GetSql
{
	private SqlConn sqlConn;
	

	public GetSql(String paramFile) throws Exception
	{
		sqlConn = new SqlConn();
		Properties prop = new Properties();
		prop.load(new FileInputStream(paramFile));
		// driver = prop.getProperty("driver");
		sqlConn.setUrl(prop.getProperty("url"));
		sqlConn.setUser(prop.getProperty("user"));
		sqlConn.setPass(prop.getProperty("pass"));
	}

	public SqlConn getSqlConn()
	{
		return this.sqlConn;
	}
	public void setSqlConn(SqlConn sqlConn)
	{
		this.sqlConn = sqlConn;
	}
}