package com.leon.artofpatternv2.ch10Bridge;

public class Ch10BridgeClient
{
	public static void main(String[] args)
	{
		Image image = new JPGImage();
		ImageImpl imageImpl = new WindownImageImpl();

		image.setImageImpl(imageImpl);
		image.parseFile("小龙女");
	}
}

class Matrix
{

}

abstract class Image
{
	protected ImageImpl imageImpl;

	public void setImageImpl(ImageImpl imageImpl)
	{
		this.imageImpl = imageImpl;
	}

	public abstract void parseFile(String fileName);
}

interface ImageImpl
{
	public void doPaint(Matrix matrix);
}

class WindownImageImpl implements ImageImpl
{

	@Override
	public void doPaint(Matrix matrix)
	{
		System.out.println(this.getClass().getSimpleName() + " doPaint");
	}
}

class LinuxImageImpl implements ImageImpl
{
	@Override
	public void doPaint(Matrix matrix)
	{
		System.out.println(this.getClass().getSimpleName() + " doPaint");
	}
}

class UnixImageImpl implements ImageImpl
{
	@Override
	public void doPaint(Matrix matrix)
	{
		System.out.println(this.getClass().getSimpleName() + " doPaint");
	}
}

class JPGImage extends Image
{

	@Override
	public void parseFile(String fileName)
	{
		Matrix matrix = new Matrix();
		this.imageImpl.doPaint(matrix);
		System.out.println(fileName + ", 格式为 " + this.getClass().getSimpleName());
	}
}

class PNGImage extends Image
{

	@Override
	public void parseFile(String fileName)
	{
		Matrix matrix = new Matrix();
		this.imageImpl.doPaint(matrix);
		System.out.println(fileName + ", 格式为 " + this.getClass().getSimpleName());
	}

}

class BMPImage extends Image
{
	@Override
	public void parseFile(String fileName)
	{
		Matrix matrix = new Matrix();
		this.imageImpl.doPaint(matrix);
		System.out.println(fileName + ", 格式为 " + this.getClass().getSimpleName());
	}
}

