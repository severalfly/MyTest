package com.leon.prototype.third;

public class ResumeMain
{
	public static void main(String[] args)
	{
		Resume r = new Resume("leon");
		r.setPersonalInfo("男", "23");
		r.setWorkExperience("123", "huoli");
		r.show();

		Resume r2 = r.clone();
		r2.setPersonalInfo("女", "256");
		r2.setWorkExperience("severalfly", "thadsoifa");
		r2.show();

		System.out.println(r.getExperience().hashCode());
		System.out.println(r2.getExperience().hashCode());
	}
}

class Resume implements Cloneable
{
	private String name;
	private String sex;
	private String age;

	private WorkExperience experience;

	public Resume(String name)
	{
		super();
		this.name = name;
		this.experience = new WorkExperience();
	}

	public void setPersonalInfo(String sex, String age)
	{
		this.sex = sex;
		this.age = age;
	}

	public void setWorkExperience(String timeArea, String company)
	{
		this.experience.setWorkDate(timeArea);
		this.experience.setCompany(company);
	}

	public WorkExperience getExperience()
	{
		return experience;
	}

	public void setExperience(WorkExperience experience)
	{
		this.experience = experience;
	}

	public void show()
	{
		System.out.println(this.name + " " + this.sex + " " + this.age);
		System.out.println("工作经历 " + this.experience.getWorkDate() + " " + this.experience.getCompany());
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

class WorkExperience
{
	private String workDate;
	private String company;

	public String getWorkDate()
	{
		return workDate;
	}

	public void setWorkDate(String workDate)
	{
		this.workDate = workDate;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

}