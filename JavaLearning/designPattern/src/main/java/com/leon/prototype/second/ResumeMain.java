package com.leon.prototype.second;

public class ResumeMain
{
	public static void main(String[] args)
	{
		Resume r = new Resume("leon");
		r.setPersonalInfo("男", "23");
		r.setWorkExperience("123", "huoli");
		r.show();

		Resume r2 = r.clone();
		r2.setPersonalInfo("女", "25");
		r2.setWorkExperience("severalfly", "thadsoifa");
		r2.show();
	}
}

class Resume implements Cloneable
{
	private String name;
	private String sex;
	private String age;
	private String timeArea;
	private String company;

	public Resume(String name)
	{
		super();
		this.name = name;
	}

	public void setPersonalInfo(String sex, String age)
	{
		this.sex = sex;
		this.age = age;
	}

	public void setWorkExperience(String timeArea, String company)
	{
		this.timeArea = timeArea;
		this.company = company;
	}

	public void show()
	{
		System.out.println(this.name + " " + this.sex + " " + this.age);
		System.out.println("工作经历 " + this.timeArea + " " + this.company);
	}

	public Resume clone()
	{
		try
		{
			return (Resume) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
