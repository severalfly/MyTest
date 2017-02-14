package com.leon.action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import com.leon.po.*;
import com.leon.service.*;


public class SubjectUpdateAction extends ActionSupport
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

		Subject subject = new Subject();
		subject.setSubjectID(this.subjectID);
		subject.setSubjectTitle(this.subjectTitle);
		subject.setSubjectOptionA(this.subjectOptionA);
		subject.setSubjectOptionB(this.subjectOptionB);
		subject.setSubjectOptionC(this.subjectOptionC);
		subject.setSubjectOptionD(this.subjectOptionD);
		subject.setSubjectAnswer(this.subjectAnswer);
		subject.setSubjectParse(this.subjectParse);
		int affect = this.subjectService.updateSubject(subject);
		if(affect > 0)
		{
			ServletActionContext.getRequest().setAttribute("subject", subject);
			this.addActionError("更新成功");
			return this.SUCCESS;
		}
		else
		{
			this.addActionError("更新失败");
			return this.INPUT;
		}
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