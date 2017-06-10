package com.leon.artofpattern.command.exercise;

import com.leon.util.XMLUtil;

public class BoardScreen
{
	private MenuItem menuItem;

	public void onClick()
	{
		this.menuItem.click();
	}

	public static void main(String[] args)
	{
		MenuItem menuItem = new MenuItem();

		MenuCommand command = (MenuCommand) XMLUtil.getBean("commandExer");
		menuItem.setCommand(command);
		menuItem.click();
	}
}
