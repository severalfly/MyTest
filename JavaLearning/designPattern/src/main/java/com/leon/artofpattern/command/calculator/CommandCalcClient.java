package com.leon.artofpattern.command.calculator;

public class CommandCalcClient
{
	public static void main(String[] args)
	{
		CalculatorForm calculatorForm = new CalculatorForm();
		AbstractCommand command = new AdderCommand();

		calculatorForm.setCommand(command);

		calculatorForm.compute(10);
		calculatorForm.compute(5);
		calculatorForm.compute(10);
		calculatorForm.undo();
		calculatorForm.undo();
		calculatorForm.undo();
	}
}
