package com.leon.artofpattern.composite;

public class VideoFile extends AbstractFile
{
	private String name;

	public VideoFile(String name)
	{
		super();
		this.name = name;
	}

	@Override
	public void add(AbstractFile file)
	{
		System.out.println("do not support this method");
	}

	@Override
	public void remove(AbstractFile file)
	{
		System.out.println("do not support this method");
	}

	@Override
	public AbstractFile getChild(int i)
	{
		System.out.println("do not support this method");
		return null;
	}

	@Override
	public void killVirus()
	{
		System.out.println("kill virus 4 video file: " + this.name);
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
