package com.leon.po;

public class Student
{
	private String studentID;
	private String password;
	private String studentName;
	private int result;
	private String sclass;

	public String getStudentID()
	{
		return this.studentID;
	}
	public void setStudentID(String studentID)
	{
		this.studentID = studentID;
	}
	public String getPassword()
	{
		return this.password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getStudentName()
	{
		return this.studentName;
	}
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}


	public int getResult()
	{
		return this.result;
	}
	public void setResult(int result)
	{
		this.result = result;
	}
	public String getSclass()
	{
		return this.sclass;
	}
	public void setSclass(String sclass)
	{
		this.sclass = sclass;
	}
}