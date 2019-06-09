package com.leon.artofpattern.bridge;

public class WindowImp implements ImageImp
{

	@Override
	public void doPaint(Matrix m)
	{
		System.out.println("do paint in windows");
	}

}
