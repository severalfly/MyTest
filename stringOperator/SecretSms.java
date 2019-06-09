

public class SecretSms
{
	public static void main(String[] args) {
		String text = "hello world!";
	}
}

class SecretString
{
	private String text;
	

	public SecretString()
	{
		
	}

	public SecretString(String text)
	{
		this.text = text;
	}


	public String getSecretString()
	{
		
	}


	public String getText()
	{
		return this.text;
	}
	public void setText(String text)
	{
		this.text = text;
	}
}