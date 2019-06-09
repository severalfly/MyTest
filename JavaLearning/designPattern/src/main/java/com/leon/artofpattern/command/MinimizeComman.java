package com.leon.artofpattern.command;

public class MinimizeComman extends Command
{
	private WindowHandler whObj;

	public MinimizeComman()
	{
		this.whObj = new WindowHandler();
	}

	@Override
	public void execute()
	{
		this.whObj.display();
	}

}
