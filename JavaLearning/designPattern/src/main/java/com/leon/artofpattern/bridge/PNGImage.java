package com.leon.artofpattern.bridge;

public class PNGImage extends Image
{

	@Override
	public void parseFile(String fileName)
	{
		Matrix m = new Matrix();
		this.imp.doPaint(m);
		System.out.println(fileName + " filetype is PNG");
	}

}
