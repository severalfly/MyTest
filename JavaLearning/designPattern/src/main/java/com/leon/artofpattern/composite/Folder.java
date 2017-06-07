package com.leon.artofpattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder extends AbstractFile
{
	private List<AbstractFile> fileList = new ArrayList<>();
	private String name;

	public Folder(String name)
	{
		super();
		this.name = name;
	}

	@Override
	public void add(AbstractFile file)
	{
		this.fileList.add(file);
	}

	@Override
	public void remove(AbstractFile file)
	{
		this.fileList.remove(file);
	}

	@Override
	public AbstractFile getChild(int i)
	{
		return this.fileList.get(i);
	}

	@Override
	public void killVirus()
	{
		for (AbstractFile file : this.fileList)
		{
			file.killVirus();
		}
	}

	public List<AbstractFile> getFileList()
	{
		return this.fileList;
	}

	public void setFileList(List<AbstractFile> fileList)
	{
		this.fileList = fileList;
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
