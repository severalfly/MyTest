package com.leon.artofpattern.command.exercise;

public class OpenCommand extends MenuCommand
{
	private InfoOpen infoOpen;

	public OpenCommand()
	{
		this.infoOpen = new InfoOpen();
	}

	@Override
	public void execute()
	{
		this.infoOpen.open();
	}

}
