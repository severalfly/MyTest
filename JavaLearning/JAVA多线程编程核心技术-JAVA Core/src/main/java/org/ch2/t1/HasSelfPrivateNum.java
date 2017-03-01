<<<<<<< HEAD
package org.ch2.t1;

public class HasSelfPrivateNum
{
	/**
	 * num 放在方法外面时，非线程安全，可被覆盖
	 */
	private int num = 0;
	/**
	 * 方法内变量为线程安全
	 * @param username
	 */
	public void addI(String username)
	{
		// num 放在方法内时，为线程安全的，
		//		int num = 0;
		try
		{
			if (username.equals("a"))
			{
				num = 100;
				System.out.println("a set over");
				Thread.sleep(2000);
			}
			else
			{
				num = 200;
				System.out.println("b set over");
			}
			System.out.println(username + " num= " + num);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
=======
package org.ch2.t1;

public class HasSelfPrivateNum
{
	/**
	 * num 放在方法外面时，非线程安全，可被覆盖
	 */
	private int num = 0;
	/**
	 * 方法内变量为线程安全
	 * @param username
	 */
	public void addI(String username)
	{
		// num 放在方法内时，为线程安全的，
		//		int num = 0;
		try
		{
			if (username.equals("a"))
			{
				num = 100;
				System.out.println("a set over");
				Thread.sleep(2000);
			}
			else
			{
				num = 200;
				System.out.println("b set over");
			}
			System.out.println(username + " num= " + num);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
>>>>>>> dd36be3a48a0e43b39b0327bc1b4cdb412b1d5bb
