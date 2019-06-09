package com.leon.artofpattern.command.exercise;

import com.leon.util.XMLUtil;

public class BoardScreen
{
	private MenuItem menuItem;

	public static void main(String[] args)
	{
		MenuItem menuItem = new MenuItem();
		// 这里还可以增加更多的menuitem
		MenuCommand command = (MenuCommand) XMLUtil.getBean("commandExer");
		menuItem.setCommand(command);
		menuItem.click();
	}
}
