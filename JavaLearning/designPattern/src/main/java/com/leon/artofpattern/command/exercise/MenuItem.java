package com.leon.artofpattern.command.exercise;

public class MenuItem
{
	private MenuCommand command;

	public MenuCommand getCommand()
	{
		return this.command;
	}

	public void setCommand(MenuCommand command)
	{
		this.command = command;
	}

	public void click()
	{
		this.command.execute();
	}
}
