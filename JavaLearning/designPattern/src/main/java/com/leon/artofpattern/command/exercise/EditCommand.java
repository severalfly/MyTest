package com.leon.artofpattern.command.exercise;

public class EditCommand extends MenuCommand
{
	private InfoEdit infoEdit;

	public EditCommand()
	{
		this.infoEdit = new InfoEdit();
	}

	@Override
	public void execute()
	{
		this.infoEdit.edit();
	}

}
