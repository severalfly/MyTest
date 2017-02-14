package  com.leon.loco.db;
public class Customer
{
	private int id;
	private String username;
	private String password;

	public int getId()
	{
		return this.id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getPassword()
	{
		return this.password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getUsername()
	{
		return this.username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
}