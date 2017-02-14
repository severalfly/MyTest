package com.leon.po;

public class Subject
{
	private int subjectID;
	private String subjectTitle;
	private String subjectOptionA;
	private String subjectOptionB;
	private String subjectOptionC;
	private String subjectOptionD;
	private String subjectAnswer;
	private String subjectParse;

	public String toString()
	{
		return this.subjectID + " " + subjectTitle ;
	}

	public int getSubjectID()
	{
		return this.subjectID;		
	}
	public void setSubjectID(int subjectID)
	{
		this.subjectID = subjectID;
	}

	public String getSubjectTitle()
	{
		return this.subjectTitle;
	}
	public void setSubjectTitle(String subjectTitle)
	{
		this.subjectTitle = subjectTitle;
	}
	public String getSubjectOptionA()
	{
		return this.subjectOptionA;
	}
	public void setSubjectOptionA(String subjectOptionA)
	{
		this.subjectOptionA = subjectOptionA;
	}

	public String getSubjectOptionB()
	{
		return this.subjectOptionB;
	}
	public void setSubjectOptionB(String subjectOptionB)
	{
		this.subjectOptionB = subjectOptionB;
	}
	public String getSubjectOptionC()
	{
		return this.subjectOptionC;
	}
	public void setSubjectOptionC(String subjectOptionC)
	{
		this.subjectOptionC = subjectOptionC;
	}
	public String getSubjectOptionD()
	{
		return this.subjectOptionD;
	}
	public void setSubjectOptionD(String subjectOptionD)
	{
		this.subjectOptionD = subjectOptionD;
	}
	public String getSubjectAnswer()
	{
		return this.subjectAnswer;
	}
	public void setSubjectAnswer(String subjectAnswer)
	{
		this.subjectAnswer = subjectAnswer;
	}
	public String getSubjectParse()
	{
		return this.subjectParse;
	}
	public void setSubjectParse(String subjectParse)
	{
		this.subjectParse = subjectParse;
	}
}