package com.leon.artofpattern.builder.exercise;

public class SimpleModle extends ShowerBuilder
{

	@Override
	public void buildMenu()
	{
		// 空字符串不显示
		this.shower.setMenu("");
	}

	@Override
	public void buildPlayList()
	{
		// 空字符串不显示
		this.shower.setPlayList("");
	}

	@Override
	public void buildMainWindow()
	{
		this.shower.setMainWindow("mainWindow");
	}

	@Override
	public void buildController()
	{
		this.shower.setController("controller");
	}

}
