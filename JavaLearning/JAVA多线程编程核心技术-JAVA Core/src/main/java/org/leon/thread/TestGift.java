package org.leon.thread;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class TestGift
{
	private volatile Map<String, Integer> map;
	private Map<String, Integer> getMap()
	{
		build();
		return map;
	}

	private void build()
	{
		if (map == null)
		{
			synchronized (this)
			{
				if (map == null)
				{
					try
					{
						//						long sleep = 100;
						//						Thread.sleep(sleep);
						map = new HashMap<String, Integer>();
						//						Thread.sleep(sleep);
						map.put("a0", 0);
						//						Thread.sleep(sleep);
						map.put("a1", 1);
						//						Thread.sleep(sleep);
						map.put("a2", 2);
						//						Thread.sleep(sleep);
						map.put("a3", 3);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		}

	}

	public void test()
	{
		for (int i = 0; i < 10; i++)
		{
			final int n = i;
			new Thread()
			{
				public void run()
				{
					String key = "";
					Map<String, Integer> map = getMap();
					try
					{
						key = "a" + n % 4;

						int x = map.get(key);
						System.out.println(x);
						//					System.out.println(map.get("a" + n % 4));
					}
					catch (Exception e)
					{
						System.out.println(Thread.currentThread().getName() + "  " + JSONObject.toJSONString(map));
						System.out.println(Thread.currentThread().getName() + "  " + "exception " + key);
						e.printStackTrace();
						System.exit(0);
					}
				};
			}.start();
		}
	}

	public static void main(String[] args)
	{
		TestGift test = new TestGift();
		test.test();
	}

}
