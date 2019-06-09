package com.leon.callback;

public class MyClient
{
	public static void main(String[] args)
	{
		MyButton button = new MyButton();
		button.setLisener(new MyLisener()
		{
			@Override
			public void onclick()
			{
				System.out.println("test call back");
			}
		});
		button.onclick();
	}
}
