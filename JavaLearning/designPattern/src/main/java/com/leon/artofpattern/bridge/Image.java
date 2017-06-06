package com.leon.artofpattern.bridge;

public abstract class Image
{
	protected ImageImp imp;

	public abstract void parseFile(String fileName);

	public ImageImp getImp()
	{
		return this.imp;
	}

	public void setImp(ImageImp imp)
	{
		this.imp = imp;
	}

}
