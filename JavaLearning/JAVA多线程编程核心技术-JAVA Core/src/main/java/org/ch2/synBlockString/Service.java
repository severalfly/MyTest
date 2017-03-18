package org.ch2.synBlockString;

public class Service
{
	private String usernameeParam;
	private String passwordParam;
	private String anyString = new String();

	public void setUsernamePassword(String username, String password)
	{
		try
		{
			synchronized (this.anyString)
			{
				System.out.println("线程名称为：" + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + " 进入同步块");
				this.usernameeParam = username;
				Thread.sleep(3000);
				this.passwordParam = password;
				System.out.println("线程名称为：" + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + " 离开同步块");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
