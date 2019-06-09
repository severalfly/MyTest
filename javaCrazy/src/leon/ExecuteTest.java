package leon;
public class ExecuteTest
{
	public void initParam(String paramFile) throws Exception
	{
		GetSql getSql = new GetSql("mysql.ini");
		SqlConn sqlconn = getSql.getSqlConn();
	}
	public static void main(String[] args) throws Exception{
		ExecuteTest ed = new ExecuteTest();
		ed.initParam("mysql.ini");
//		ed.createTable("create table jdbc_test (jdbc_id int auto_increment primary key, jdbc_name varchar(250));");
		System.out.println("Sucess");
	}
}