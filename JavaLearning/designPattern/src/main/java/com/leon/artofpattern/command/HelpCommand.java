package com.leon.artofpattern.command;

public class HelpCommand extends Command
{
	private HelpHandler hhObj;

	public HelpCommand()
	{
		super();
		this.hhObj = new HelpHandler();
	}

	@Override
	public void execute()
	{
		this.hhObj.display();
	}

}
