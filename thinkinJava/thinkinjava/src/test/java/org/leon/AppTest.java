package org.leon;

import java.util.LinkedList;
import java.util.List;

public class AppTest
{
	public static void main(String[] args)
	{

		//  测试java 分析工具
		List<String> list = new LinkedList<String>();
		while (1 < 2)
		{
			list.add("will outofmemory soon");
		}
	}
}
