import java.util.regex.*;
import java.util.*;
public class StatiscVowelNums
{
	public static void main(String[] args) {
		try
		{
			Pattern p = Pattern.compile("[aoeiu]");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please input a line: ");
			String line = scanner.nextLine();
			Matcher m = p.matcher(line);
			int cnt = 0;
			while(m.find())
			{
				cnt ++ ;
			}
			System.out.println(cnt);
		}
		catch(Exception e)
		{

		}
	}
}