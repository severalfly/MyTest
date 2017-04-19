package org.ch3.wait_notify_insert_test;

public class Runn
{
	public static void main(String[] args)
	{
		DBTools dbTools = new DBTools();
		for (int i = 0; i < 20; i++)
		{
			BackupB output = new BackupB(dbTools);
			output.start();
			BackupA input = new BackupA(dbTools);
			input.start();
		}
	}
}

class DBTools
{

	volatile private boolean prevIsA = false;

	synchronized public void backupA()
	{
		try
		{
			while (prevIsA)
			{
				wait();
			}
			for (int i = 0; i < 5; i++)
			{
				System.out.println("*****");
			}
			prevIsA = true;
			notifyAll();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	synchronized public void backupB()
	{
		try
		{
			while (!prevIsA)
			{
				wait();
			}
			for (int i = 0; i < 5; i++)
			{
				System.out.println("&&&&&");
			}
			prevIsA = false;
			notifyAll();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}

class BackupA extends Thread
{
	private DBTools dbTools;

	public BackupA(DBTools dbTools)
	{
		super();
		this.dbTools = dbTools;
	}

	@Override
	public void run()
	{
		dbTools.backupA();
	}
}

class BackupB extends Thread
{
	private DBTools dbTools;

	public BackupB(DBTools dbTools)
	{
		super();
		this.dbTools = dbTools;
	}

	@Override
	public void run()
	{
		dbTools.backupB();
	}
}