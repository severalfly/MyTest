package com.leon.artofpattern.command;

public class CommandClient
{
	public static void main(String[] args)
	{
		FBSettingWindow fbsw = new FBSettingWindow("function button setting");
		FunctionButton fb1 = new FunctionButton("fb1");
		FunctionButton fb2 = new FunctionButton("fb2");

		//		Command cm1 = new HelpCommand();
		//		Command cm2 = new MinimizeComman();

		Command cm1 = new MinimizeComman();
		Command cm2 = new HelpCommand();

		fb1.setCommand(cm1);
		fb2.setCommand(cm2);
		fbsw.addFunctionButton(fb1);
		fbsw.addFunctionButton(fb2);

		fb1.onClick();
		fb2.onClick();
	}
}
