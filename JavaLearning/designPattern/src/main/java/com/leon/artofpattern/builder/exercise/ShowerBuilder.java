package com.leon.artofpattern.builder.exercise;

public abstract class ShowerBuilder
{
	protected Shower shower = new Shower();

	//	private String menu;
	//	private String playList;
	//	private String mainWindow;
	//	private String controller;
	public abstract void buildMenu();

	public abstract void buildPlayList();

	public abstract void buildMainWindow();

	public abstract void buildController();

	public Shower createShower()
	{
		this.buildMenu();
		this.buildPlayList();
		this.buildMainWindow();
		this.buildController();
		return this.shower;
	}

}
