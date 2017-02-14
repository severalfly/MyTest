package com.leon.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest
{
	public static void main(String[] args)
	{
		StringBuilder text = new StringBuilder();
		text.append(
				"A word inflectionally generated from another (for example, the word drive is the inflectional stem of drives, drove, driving, and driven)");
		text.append(
				"A word inflectionally generated from another (for example, the word drive is the inflectional stem of drives, drove, driving, and driven)");
		text.append("Searches for precise or fuzzy (less precise) matches to single words and phrases, "
				+ "words within a certain distance of one another, or weighted matches in SQL Server. CONTAINS is a predicate used in the WHERE clause of a Transact-SQL SELECT statement to perform SQL Server full-text search on full-text indexed columns containing character-based data types.");
		Pattern p = Pattern.compile("\\*data types\\*");
		for (int i = 0; i < 2; i++)
		{
			long all = 0;
			long all2 = 0;
			int times = 10000000;
			text.append(i);
			String tmp = text.toString();
			// 开始计算contains 耗时
			int j = 0;
			long now = System.currentTimeMillis();
			while (j < times)
			{
				tmp.contains("data types");
				j++;
			}
			long last = System.currentTimeMillis() - now;
			all += last;

			// 开始计算 pattern 耗时
			j = 0;
			now = System.currentTimeMillis();
			while (j < times)
			{
				Matcher m = p.matcher(tmp);
				m.matches();
				j++;
			}
			last = System.currentTimeMillis() - now;
			all2 += last;
			System.out.println("contains result: " + all);
			System.out.println("pattern result: " + all2);
			System.out.println();
		}
	}

}
