package com.leon.artofpattern.builder.exercise;

import com.leon.util.ObjectUtil;

public class Shower
{
	private String menu;
	private String playList;
	private String mainWindow;
	private String controller;

	public String getMenu()
	{
		return this.menu;
	}

	public void setMenu(String menu)
	{
		this.menu = menu;
	}

	public String getPlayList()
	{
		return this.playList;
	}

	public void setPlayList(String playList)
	{
		this.playList = playList;
	}

	public String getMainWindow()
	{
		return this.mainWindow;
	}

	public void setMainWindow(String mainWindow)
	{
		this.mainWindow = mainWindow;
	}

	public String getController()
	{
		return this.controller;
	}

	public void setController(String controller)
	{
		this.controller = controller;
	}

	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		if (ObjectUtil.isNotNull(this.menu))
		{
			sb.append(this.menu + "\n");
		}
		if (ObjectUtil.isNotNull(this.playList))
		{
			sb.append(this.playList + "\n");
		}
		if (ObjectUtil.isNotNull(this.mainWindow))
		{
			sb.append(this.mainWindow + "\n");
		}
		if (ObjectUtil.isNotNull(this.controller))
		{
			sb.append(this.controller + "\n");
		}
		return sb.toString();
	}

}
