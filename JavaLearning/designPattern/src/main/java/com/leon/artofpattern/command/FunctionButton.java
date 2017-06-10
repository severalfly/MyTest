package com.leon.artofpattern.command;

public class FunctionButton
{
	private String name;
	private Command command;

	public FunctionButton(String name)
	{
		super();
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Command getCommand()
	{
		return this.command;
	}

	public void setCommand(Command command)
	{
		this.command = command;
	}

	public void onClick()
	{
		System.out.println("hit function button");
		this.command.execute();
	}
}
