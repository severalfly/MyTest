package com.leon.artofpatternv2.ch10Bridge;

public class Ch10BridgeExisClient
{
	public static void main(String[] args)
	{
		Database database = new MysqlDatabase();

		Format format = new XmlFile();

		database.setFormat(format);
		database.change("fileName: leon");

	}
}

abstract class Database
{
	protected Format format;

	public void setFormat(Format format)
	{
		this.format = format;
	}

	abstract void change(String fileName);
}

interface Format
{
	public void doFormat();
}

class TxtFile implements Format
{

	@Override
	public void doFormat()
	{
		System.out.println(this.getClass().getSimpleName() + " do format");
	}
}

class XmlFile implements Format
{
	@Override
	public void doFormat()
	{
		System.out.println(this.getClass().getSimpleName() + " do format");
	}
}

class PDFFile implements Format
{
	@Override
	public void doFormat()
	{
		System.out.println(this.getClass().getSimpleName() + " do format");
	}
}

class OrocleDatabase extends Database
{

	@Override
	void change(String fileName)
	{

		this.format.doFormat();
		System.out.println(this.getClass().getSimpleName() + " changing");
	}
}

class MysqlDatabase extends Database
{

	@Override
	void change(String fileName)
	{

		this.format.doFormat();
		System.out.println(this.getClass().getSimpleName() + " changing");
	}
}

