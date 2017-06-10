package com.leon.artofpattern.command.calculator;

import java.util.Stack;

public class AdderCommand extends AbstractCommand
{
	private Adder adder;
	// 被加数，用于撤销，只可撤销一次
	private int value;
	// 存储所有被加数，可摊销多次
	private Stack<Integer> values;

	public AdderCommand()
	{
		this.adder = new Adder();
		this.values = new Stack<Integer>();
	}

	@Override
	public int execute(int value)
	{
		this.values.push(value);
		return this.adder.add(value);
	}

	@Override
	public int undo()
	{
		if (this.values.size() > 0)
		{
			return this.adder.add(-this.values.pop());
		}
		else
		{
			return 0;
		}
	}

}
