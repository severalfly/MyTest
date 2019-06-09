package com.leon.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestEmail
{
	public static void main(String[] args)
	{
		String str = "-1234). by email(wwspam_a@wwspam.fu) or visiting (http://wwspam.fu/feedback).";
		Pattern pattern = Pattern.compile("([a-zA-Z_]+?)@([a-zA-Z_]+?\\.[a-zA-Z]{2,})");
		Matcher matcher = pattern.matcher(str);
		matcher.find();
		//		System.out.println(matcher.group(0));
		//		System.out.println(matcher.group(1));
		//		System.out.println(matcher.group(2));
		//		System.out.println(matcher.group(3));
		System.out.println(matcher.replaceAll("$1#$2"));
		//		StringUtils.equalsIgnoreCase(str1, str2)

		System.out.println(System.nanoTime());
		System.out.println(System.currentTimeMillis());

	}
}
