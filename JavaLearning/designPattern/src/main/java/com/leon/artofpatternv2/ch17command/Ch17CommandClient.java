package com.leon.artofpatternv2.ch17command;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Ch17CommandClient
{
	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException
	{
		FBSSettingWindow window = new FBSSettingWindow("功能键窗口");
		FunctionButton button1 = new FunctionButton("button1");
		FunctionButton button2 = new FunctionButton("button2");
		String c2 = "com.leon.artofpatternv2.ch17command.HelpCommand";
		String c1 = "com.leon.artofpatternv2.ch17command.MinWindowCommand";
		String c3 = "com.leon.artofpatternv2.ch17command.MaxWindowCommand";
		Command command1 = (Command) Class.forName(c1).newInstance();
		Command command2 = (Command) Class.forName(c2).newInstance();
		Command command3 = (Command) Class.forName(c3).newInstance();

		button1.setCommand(command1);
		button2.setCommand(command3);

		window.addFunctionButton(button1);
		window.addFunctionButton(button2);

		window.display();
	}
}

@Setter
@Getter
class FBSSettingWindow
{
	private String title;
	private List<FunctionButton> functionButtons = new ArrayList<>();

	public FBSSettingWindow(String title)
	{
		this.title = title;
	}

	public void addFunctionButton(FunctionButton button)
	{
		this.functionButtons.add(button);
	}

	public void removeFunctionButton(FunctionButton button)
	{
		this.functionButtons.remove(button);
	}

	public void display()
	{
		for (FunctionButton button : this.functionButtons)
		{
			button.onclick();
		}
	}
}

@Setter
@Getter
class FunctionButton
{
	private String name;
	private Command command;

	public FunctionButton(String name)
	{
		this.name = name;
	}

	public void onclick()
	{
		this.command.execute();
	}

}

abstract class Command
{
	abstract void execute();
}

class HelpCommand extends Command
{
	private HelpHandler helpHandler;

	public HelpCommand()
	{
		this.helpHandler = new HelpHandler();
	}

	@Override
	void execute()
	{
		this.helpHandler.display();

	}
}

class MinWindowCommand extends Command
{
	private WindowHandler handler;

	public MinWindowCommand()
	{
		this.handler = new WindowHandler();
	}

	@Override
	void execute()
	{
		this.handler.display();
	}
}class MaxWindowCommand extends Command
{
	private WindowMaxHandler handler;

	public MaxWindowCommand()
	{
		this.handler = new WindowMaxHandler();
	}

	@Override
	void execute()
	{
		this.handler.display();
	}
}

class HelpHandler
{
	public void display()
	{
		System.out.println(this.getClass().getSimpleName() + " display");
	}
}

class WindowHandler
{
	public void display()
	{
		System.out.println(this.getClass().getSimpleName() + " display");
	}
}class WindowMaxHandler
{
	public void display()
	{
		System.out.println(this.getClass().getSimpleName() + " display");
	}
}
