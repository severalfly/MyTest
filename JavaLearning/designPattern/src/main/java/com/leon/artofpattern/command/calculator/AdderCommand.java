package com.leon.artofpattern.command.calculator;

public class AdderCommand extends AbstractCommand
{
	private Adder adder;
	// 被加数，用于撤销
	private int value;

	public AdderCommand()
	{
		this.adder = new Adder();
	}

	@Override
	public int execute(int value)
	{
		this.value = value;
		return this.adder.add(value);
	}

	@Override
	public int undo()
	{
		return this.adder.add(-this.value);
	}

}
