package com.leon.effectiveJava.ch6;

import java.util.Date;

public class AnnotationBeforenamingPattern
{
	public static void main(String[] args)
	{
		Date date = new Date();
		System.out.println(date.getTime());
	}

	/**
	 * {@code <p>ahodfi</p>}
	 */
	public void testDoc()
	{
		System.out.println(new Date());
	}
}