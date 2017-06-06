package com.leon.artofpattern.bridge;

public class UnixImp implements ImageImp
{

	@Override
	public void doPaint(Matrix m)
	{
		System.out.println("do paint in unix");
	}

}
