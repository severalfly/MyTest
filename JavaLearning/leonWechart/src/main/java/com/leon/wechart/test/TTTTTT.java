package com.leon.wechart.test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

import com.leon.wechart.schedule.test.TestThreadLocalWorker;

public class TTTTTT
{

	@Test
	public void testtt()
	{
		System.out.println(Long.toString(Long.MAX_VALUE, 16));
		System.out.println(Long.parseLong("691000fe6edc12ed", 16));
	}
	//	@Test
	public void urlencode() throws UnsupportedEncodingException
	{
		System.out.println(URLEncoder.encode("南京", "gbk"));
		System.out.println(URLEncoder.encode("南京", "utf-8"));
		System.out.println("-E5-8D-97-E4-BA-AC".replaceAll("-", "%"));
		System.out.println(URLDecoder.decode("%E5%8D%97%E4%BA%AC", "utf-8"));
		String s1 = "abcd";
		String s2 = "bcd\t";
		System.out.println(s2.trim() + s1);
	}

	//	@Test
	public void testInetege()
	{
		int i = new Integer(1111);
		System.out.println(Integer.toString(3, 2));
		System.out.println(Integer.toString(3 * 100, 2));
		System.out.println(Integer.parseInt("123"));
	}

	//	@Test
	public void testEnum()
	{
	}

	//	@Test
	public void testBigdecimal()
	{
		System.out.println(new BigDecimal(10));
	}

	//	@Test
	public void testThreadLocal() throws InterruptedException
	{

		TestThreadLocalWorker[] ts = new TestThreadLocalWorker[10];
		for (int i = 0; i < 10; i++)
		{
			TestThreadLocalWorker th = new TestThreadLocalWorker();
			th.th = "out: " + i;
			ts[i] = th;
		}
		for (int i = 0; i < 10; i++)
		{
			ts[i].start();
		}
		//		Thread.sleep(1 * 1000);
		//		Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new TestThreadLocalWorker(), TestThreadLocalWorker.firstDelay(), 10 * 1000, TimeUnit.MILLISECONDS);

	}

	//	@Test
	public void testClassLoad()
	{
		//		ClassLoader.get
	}

	//	@Test
	public void testLinkedList()
	{
		List<String> list = new LinkedList<>();
		for (String string : list)
		{

		}
		Map<String, Object> map = new HashMap<>();
		for (Map.Entry<String, Object> me : map.entrySet())
		{

		}

		Stack<String> stack = new Stack<>();
		stack.push("huo");
		stack.push("li");
		for (String string : stack)
		{
			System.out.println(string);
		}

	}

	@Test
	public void testCache()
	{
		TestHashMap<String, Object> map = new TestHashMap<String, Object>();
		map.put("1", "1");
		map.put("2", "2");
		System.out.println(map.get("1"));
		map.put("3", "3");
		map.put("4", "4");

		map.put("5", "5");
		System.out.println(map.get("1"));
	}

}

class TestHashMap<K, V> extends LinkedHashMap<K, V>
{
	private LinkedHashMap<K, V> cache = null;
	private int cacheSize = 3;

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest)
	{
		System.out.println("size=" + size());
		return size() > TestHashMap.this.cacheSize;
	}
}
