package sendSms;

public class SecretString
{
	private String text;

	public SecretString()
	{

	}

	public SecretString(String text)
	{
		this.text = text;
	}

	// ¼ÓÃÜ×Ö·û´®
	public String getSecretString()
	{
		String result = "";
		for (char c : text.toCharArray())
		{
			result = c + result;
		}
		return result;
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
