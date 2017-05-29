package com.leon.effectiveJava.ch6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

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

	@Test
	public void testNaturalOrder()
	{
		Comparator<OrderTest> naturalOrder = new Comparator<OrderTest>()
		{

			public int compare(OrderTest first, OrderTest second)
			{
				return first.getInd() < second.getInd() ? -1 : (first.getInd() == second.getInd() ? 0 : 1);
			}
		};
		List<OrderTest> list = new ArrayList<AnnotationBeforenamingPattern.OrderTest>();
		OrderTest first = new OrderTest(new Integer(142), "first");
		OrderTest second = new OrderTest(new Integer(142), "second");
		list.add(second);
		list.add(first);
		Collections.sort(list, naturalOrder);
		System.out.println(JSONObject.toJSONString(list));

		//		Integer f = new Integer(1);
		//		Integer s = new Integer(1);
		Integer f = Integer.valueOf(145);
		Integer s = Integer.valueOf(145);
		System.out.println(f < s ? -1 : (f == s ? 0 : 1));

		System.out.println(Integer.toString(3, 3));
	}

	class OrderTest
	{
		private Integer ind;
		private String content;

		public OrderTest(Integer ind, String content)
		{
			super();
			this.ind = ind;
			this.content = content;
		}

		public Integer getInd()
		{
			return ind;
		}

		public void setInd(Integer ind)
		{
			this.ind = ind;
		}

		public String getContent()
		{
			return content;
		}

		public void setContent(String content)
		{
			this.content = content;
		}

	}
}