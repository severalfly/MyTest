package org.fenixsoft.build;

import java.util.List;

public class GenericTypes
{
	public static String method(List<String> list)
	{
		System.out.println("invoke method(List<String> list)");
		return "";
	}

	public static int method(List<Integer> list)
	{
		System.out.println("invoke method(List<Integer> list)");
		return 0;
	}

	public static void main(String[] args)
	{
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 3;
		Integer e = 321;
		Integer f = 321;
		Long g = 3L;
		System.out.println(c == d);
		System.out.println(e == f);
		System.out.println(c == (a + b));
		System.out.println(c.equals(a + b));
		System.out.println(g == (a + b));
		System.out.println(g.equals(a + b));
		/** 思考之后，应该的输出
		 * true
		 * false
		 * true
		 * true
		 * true
		 * true
		 */
		/** 实际输出
		 * true
			false
			true
			true
			true
			false
*/
	}
}
