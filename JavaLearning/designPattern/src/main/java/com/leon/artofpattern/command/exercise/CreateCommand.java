package com.leon.artofpattern.command.exercise;

public class CreateCommand extends MenuCommand
{
	private InfoCreate infoCreate;

	public CreateCommand()
	{
		this.infoCreate = new InfoCreate();
	}

	@Override
	public void execute()
	{
		this.infoCreate.create();
	}

}
