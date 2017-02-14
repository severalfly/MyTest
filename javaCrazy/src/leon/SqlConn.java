package leon;
public class SqlConn
{
	private String url;
	private String user;
	private String pass;

	public void setUrl(String url)
	{
		this.url = url;
	}
	public String getUrl()
	{
		return this.url;
	}
	public void setUser(String user)
	{
		this.user = user;
	}
	public String getUser()
	{
		return this.user;
	}
	public void setPass(String pass)
	{
		this.pass = pass;
	}
}