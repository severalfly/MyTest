package org.leon.outmomery;

public class YoungOutMemory
{
	/**
	 * XX：MaxTenuringThreshold 设置为很大的值
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args)
	{
		try
		{
			//		
			//	}
			GCMemoryObject object1 = new GCMemoryObject(2);
			GCMemoryObject object2 = new GCMemoryObject(8);
			GCMemoryObject object3 = new GCMemoryObject(8);
			GCMemoryObject object4 = new GCMemoryObject(8);
			object2 = null;
			object3 = null;
			GCMemoryObject object5 = new GCMemoryObject(800);
			Thread.sleep(4000);
			object2 = new GCMemoryObject(8222);
			object3 = new GCMemoryObject(8);
			object2 = null;
			object3 = null;
			object5 = null;
			GCMemoryObject object6 = new GCMemoryObject(8);
			Thread.sleep(5000);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

class GCMemoryObject
{
	private byte[] bytes = null;

	public GCMemoryObject(int multi)
	{
		bytes = new byte[1024 * 256 * multi];
	}
}
