package com.leon.artofpattern.command;

import java.util.ArrayList;
import java.util.List;

public class FBSettingWindow
{
	private String title;
	private List<FunctionButton> functionButtons = new ArrayList<FunctionButton>();

	public FBSettingWindow(String title)
	{
		super();
		this.title = title;
	}

	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void addFunctionButton(FunctionButton fb)
	{
		this.functionButtons.add(fb);
	}

	public void removeFunctionButton(FunctionButton fb)
	{
		this.functionButtons.remove(fb);
	}

	public void display()
	{
		System.out.println("display window: " + this.title);
		System.out.println("display function button:");
		for (FunctionButton fb : this.functionButtons)
		{
			System.out.println(fb.getName());
		}
		System.out.println("---------------------");
	}

}
