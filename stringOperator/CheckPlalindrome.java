import java.util.*;
public class CheckPlalindrome
{
	public static void main(String[] args) {
		try
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("please input a line: ");
			String line = scanner.nextLine();
			System.out.println("the origin line is: " + line);
			Plalindrome p = new Plalindrome(line);
			System.out.println(p.isPlalindrome());

		}
		catch(Exception e)
		{

		}
	}


}

class Plalindrome
{
	private String line;
	Plalindrome()
	{

	}
	Plalindrome(String line)
	{
		this.line = line;
	}


	public boolean isPlalindrome()
	{
		String reverseLine = doReverse();
		if(reverseLine.equals(this.line))
		{
			return true;
		}
		return false;
	}
	private String doReverse()
	{
		StringBuffer sb = new StringBuffer();
		for (int i = this.line.length() - 1; i >= 0; i--) {
			sb.append(line.charAt(i));
		}
		return sb.toString();
	}



	public void setLine(String line)
	{
		this.line = line;
	}
	public String getLine()
	{
		return this.line;
	}
}