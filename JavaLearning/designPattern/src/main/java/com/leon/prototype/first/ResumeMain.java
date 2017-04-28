package com.leon.prototype.first;

public class ResumeMain
{
	public static void main(String[] args)
	{
		Resume r = new Resume("leon");
		r.setPersonalInfo("男", "23");
		r.setWorkExperience("123", "huoli");
		r.show();

		r = new Resume("severalfly");
		r.setPersonalInfo("女", "25");
		r.setWorkExperience("123", "歪睚沟菲");
		r.show();

		r = new Resume("note.youdao.com");
		r.setPersonalInfo("男", "23");
		r.setWorkExperience("123", "huoli");
		r.show();
	}
}

class Resume
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
}


