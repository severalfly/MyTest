package com.leon.artofpattern.composite;

public class ImageFile extends AbstractFile
{
	private String name;

	public ImageFile(String name)
	{
		super();
		this.name = name;
	}

	@Override
	public void add(AbstractFile file)
	{
		System.out.println("image do not support add method");
	}

	@Override
	public void remove(AbstractFile file)
	{
		System.out.println("image do not support remove method");
	}

	@Override
	public AbstractFile getChild(int i)
	{
		System.out.println("image do not support getChild");
		return null;
	}

	@Override
	public void killVirus()
	{
		System.out.println("kill virus 4 image file: " + this.name);
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
