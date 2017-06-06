package com.leon.artofpattern.bridge.exercise;

public abstract class Format
{
	protected FormatImp imp;

	//转换并保存
	public abstract void save();

	public FormatImp getImp()
	{
		return this.imp;
	}

	public void setImp(FormatImp imp)
	{
		this.imp = imp;
	}

}
