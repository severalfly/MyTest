package com.leon.artofpattern.builder.exercise;

public class MemoryModle extends ShowerBuilder
{

	@Override
	public void buildMenu()
	{
		// 空字符串为不显示
		this.shower.setMenu("");
	}

	@Override
	public void buildPlayList()
	{
		this.shower.setPlayList("playList");
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
