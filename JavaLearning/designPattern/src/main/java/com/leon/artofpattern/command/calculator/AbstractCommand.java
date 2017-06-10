package com.leon.artofpattern.command.calculator;

public abstract class AbstractCommand
{
	public abstract int execute(int value);

	public abstract int undo();
}
