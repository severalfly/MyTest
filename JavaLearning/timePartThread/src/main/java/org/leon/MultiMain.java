package org.leon;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MultiMain
{
	// 一分钟实现“延迟消息”功能
	/**
	 * 高效延时消息，包含两个重要的数据结构：
	
	（1）环形队列，例如可以创建一个包含3600个slot的环形队列（本质是个数组）
	
	（2）任务集合，环上每一个slot是一个Set<Task>
	
		同时，启动一个timer，这个timer每隔1s，在上述环形队列中移动一格，有一个Current Index指针来标识正在检测的slot。
	
	Task结构中有两个很重要的属性：
	
	（1）Cycle-Num：当Current Index第几圈扫描到这个Slot时，执行任务
	
	（2）Task-Function：需要执行的任务指针
	 */
	private static int COUNT = 3600;

	private static List<List<Node>> business = new ArrayList<List<Node>>(COUNT);
	public static void main(String[] args)
	{
		for (int i = 0; i < COUNT; i++)
		{
			business.add(new LinkedList<MultiMain.Node>());
		}
		// 添加几个任务
		addNode(1);
		addNode(2);
		addNode(2);
		addNode(2);
		addNode(2);
		addNode(5);
		addNode(5);
		addNode(5);
		addNode(5);
		addNode(5);
		addNode(5);
		addNode(5);
		addNode(5);
		addNode(5);
		System.out.println(new Timestamp(System.currentTimeMillis()));
		// 开始循环任务
		int location = 0;
		while (true)
		{
			try
			{
				long now = System.currentTimeMillis();
				List<Node> list = business.get(location);
				for (int i = 0; i < list.size(); i++)
				{
					Node node = list.get(i);
					node.setHour(node.getHour() - 1);
					if (node.getHour() < 0)
					{
						node.setDay(node.getDay() - 1);
					}
					if (node.getDay() < 0)
					{
						// 启动任务
						node.getTask().start();
						list.remove(i--);

					}
				}
				location++;
				location = location % COUNT;
				long s = 1000l - (System.currentTimeMillis() - now) - 1;
				if (s > 0)
				{
					Thread.sleep(s);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
				break;
			}
		}
	}

	private static void addNode(int second)
	{
		int hour = second / COUNT;
		int day = second / COUNT / 24;
		List<Node> list = business.get(second % COUNT);
		list.add(new Node(day, hour, new Task()));
	}

	public static class Node
	{
		private int day;
		private int hour;
		private Task task;

		public Node(int day, int hour, Task task)
		{
			this.day = day;
			this.hour = hour;
			this.task = task;
		}


		public int getDay()
		{
			return day;
		}

		public void setDay(int day)
		{
			this.day = day;
		}

		public int getHour()
		{
			return hour;
		}

		public void setHour(int hour)
		{
			this.hour = hour;
		}

		public Task getTask()
		{
			return task;
		}

		public void setTask(Task task)
		{
			this.task = task;
		}
	}

	public static class Task extends Thread
	{
		@Override
		public void run()
		{
			System.out.println(Thread.currentThread().getName() + " " + new Timestamp(System.currentTimeMillis()));
		}
	}
}
