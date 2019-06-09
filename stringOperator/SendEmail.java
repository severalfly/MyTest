import javax.mail.*;
public class SendEmail
{
	private 
}

class SendEmails extends Authenticator
{
	private String username;

	private String password;

	public SendEmails(String username, String password)
	{
		this.username = username;
		this.password = password;
	}

	public String getPassword()
	{
		return this.password;
	}
	@Override
	protected PasswordAuthentication getPasswordAuthentication()
	{
		return new PasswordAuthentication(username, password);
	}

	public String getUsername()
	{
		return this.username;
	}
}

}