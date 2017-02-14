import java.util.*;
public class PigLatterGame
{
	public static String consonants = "bdfg";
	public static void main(String[] args) {
		try{

			Scanner scanner = new Scanner(System.in);
			System.out.println("please input a line: ");
			String line = scanner.nextLine();
			System.out.println("the origin line is: " + line);
			System.out.println("the result is: " + doPigGame(line));

		}
		catch(Exception e)
		{

		}

	}
	public static String doPigGame(String line)
	{
		String result = "";
		boolean foundFirst = false;
		char d = '\0';
		for (char c : line.toCharArray()) 
		{
			if(!foundFirst && consonants.contains(c+""))
			{
				d = c;
			}
			else
			{
				result += c;
			}
		}
		result = result + '-' + d + "ay";
		return result;
	}





}