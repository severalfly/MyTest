import java.util.*;
import java.util.regex.*;
public class WordsNum
{
	public static void main(String[] args) {
		try
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please input a line:");
			String line = scanner.nextLine();
			System.out.println("Please input the word to find:");
			String word = scanner.nextLine();

			Nums nums = new Nums();
			nums.setLine(line);
			nums.setWord(word);
			System.out.println(nums.nums());

		}
		catch(Exception e)
		{

		}
	}
}

class Nums
{
	private String line;
	private String word;

	public int nums()
	{
		Pattern p = Pattern.compile(this.word);
		Matcher m = p.matcher(this.line);
		int cnt = 0;
		while(m.find())
		{
			cnt ++;
		}
		return cnt;
	}

	public void setLine(String line)
	{
		this.line = line;
	}
	public String getLine()
	{
		return this.line;
	}
	public void setWord(String word)
	{
		this.word = word;
	}
	public String getWord()
	{
		return this.word;
	}
}