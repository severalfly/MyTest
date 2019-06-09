package org.leon.thread.conmap;

import java.util.HashMap;

public class Stroe
{
	public static HashMap<String, Integer> map = new HashMap<String, Integer>();

	public void addKey(String key)
	{
		synchronized (map)
		{
			int a = 0;
			if (map.containsKey(key))
			{
				a = map.get(key);
			}
			map.put(key, a + 1);
		}
	}

}
