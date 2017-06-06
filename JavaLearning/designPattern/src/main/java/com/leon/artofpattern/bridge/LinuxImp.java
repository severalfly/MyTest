package com.leon.artofpattern.bridge;

public class LinuxImp implements ImageImp
{

	@Override
	public void doPaint(Matrix m)
	{
		System.out.println("do paint in linux");
	}

}
