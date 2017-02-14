import java.util.*;
public class ReverseString
{
	public static void main(String[] args) {
		try{
			Scanner scanner = new Scanner(System.in);
			System.out.println("please input a string: ");
			String i = scanner.nextLine();
			System.out.println("the orgin line is: " + i);
			System.out.println("the result line is: " + doReverse(i));
		}
		catch (Exception e)
		{
			System.out.println("error");
		}
		}

	public static String doReverse(String line)
	{
		StringBuffer sb = new StringBuffer();
		for (int i = line.length()-1; i>=0; i--) {
			sb.append(line.charAt(i));
		}
		return sb.toString();
		
	}
}