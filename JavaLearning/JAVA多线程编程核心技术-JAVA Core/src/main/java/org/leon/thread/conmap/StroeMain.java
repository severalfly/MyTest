package org.leon.thread.conmap;

import com.alibaba.fastjson.JSONObject;

public class StroeMain
{
	public static void main(String[] args)
	{
		for (int i = 0; i < 100000; i++)
		{
			new AddThread().start();
		}
		System.out.println(JSONObject.toJSONString(Stroe.map));
	}
}

class AddThread extends Thread
{
	@Override
	public void run()
	{
		try
		{
			new Stroe().addKey("AAAA");
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}