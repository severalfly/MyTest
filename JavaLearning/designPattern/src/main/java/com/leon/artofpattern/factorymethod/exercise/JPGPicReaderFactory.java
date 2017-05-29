package com.leon.artofpattern.factorymethod.exercise;

public class JPGPicReaderFactory implements PicReaderFactory
{

	@Override
	public PicReader getReader()
	{
		return new JPGPicReader();
	}

}
