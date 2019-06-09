package com.leon.action;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServlet;

import com.leon.po.*;
import com.leon.service.*;


public class SubjectAddAction extends ActionSupport
{
	private int subjectID;
	private String subjectTitle;
	private String subjectOptionA;
	private String subjectOptionB;
	private String subjectOptionC;
	private String subjectOptionD;
	private String subjectAnswer;
	private String subjectParse;
	private SubjectServiceImpl subjectService = new SubjectServiceImpl();

	public String execute() throws Exception
	{
		try
		{

			Subject subject = new Subject();
			subject.setSubjectTitle(this.subjectTitle);
			subject.setSubjectOptionA(this.subjectOptionA);
			subject.setSubjectOptionB(this.subjectOptionB);
			subject.setSubjectOptionC(this.subjectOptionC);
			subject.setSubjectOptionD(this.subjectOptionD);
			subject.setSubjectAnswer(this.subjectAnswer);
			subject.setSubjectParse(this.subjectParse);
			if(this.subjectService.saveSubject(subject))
			{
				System.out.println("test success");
				return this.SUCCESS;
			}
			else
			{
				System.out.println("test fail");
				this.addActionError("该试题已经添加过了，请不要重复添加！");
				return this.INPUT;
			}
		}
		catch (Exception e) {
			// e.printStackTrace();
		}
		// System.out.println("test success action");
		return this.SUCCESS;
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