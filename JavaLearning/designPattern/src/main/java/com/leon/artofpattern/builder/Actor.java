package com.leon.artofpattern.builder;

public class Actor
{
	private String type;
	private String sex;
	private String face;

	public String getType()
	{
		return this.type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getSex()
	{
		return this.sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getFace()
	{
		return this.face;
	}

	public void setFace(String face)
	{
		this.face = face;
	}

	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(this.type + "外观\n");
		sb.append("sex: " + this.sex + "\n");
		sb.append("face: " + this.face + "\n");
		return sb.toString();
	}
}
