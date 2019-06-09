package com.leon.artofpattern.builder.exercise;

public class FullModle extends ShowerBuilder
{

	@Override
	public void buildMenu()
	{
		this.shower.setMenu("menu");
	}

	@Override
	public void buildPlayList()
	{
		this.shower.setPlayList("playLIst");
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
