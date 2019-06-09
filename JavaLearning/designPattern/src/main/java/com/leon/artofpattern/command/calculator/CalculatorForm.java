package com.leon.artofpattern.command.calculator;

public class CalculatorForm
{
	private AbstractCommand command;

	public void compute(int value)
	{
		int i = this.command.execute(value);
		System.out.println("calculator result is: " + i);
	}

	public void undo()
	{
		int i = this.command.undo();
		System.out.println("undo result: " + i);
	}

	public AbstractCommand getCommand()
	{
		return this.command;
	}

	public void setCommand(AbstractCommand command)
	{
		this.command = command;
	}

}
