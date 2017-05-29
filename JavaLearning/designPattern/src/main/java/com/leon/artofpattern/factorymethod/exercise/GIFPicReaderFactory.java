package com.leon.artofpattern.factorymethod.exercise;

public class GIFPicReaderFactory implements PicReaderFactory
{

	@Override
	public PicReader getReader()
	{
		return new GIFPicReader();
	}

}
