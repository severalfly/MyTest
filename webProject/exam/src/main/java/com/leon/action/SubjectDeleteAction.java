package com.leon.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import com.leon.po.*;
import com.leon.service.*;
import javax.servlet.*;


public class SubjectDeleteAction extends ActionSupport
{
	private int subjectID;

	private SubjectServiceImpl subjectService = new SubjectServiceImpl();

	public String execute() throws Exception
	{
		int affect = subjectService.deleteSubject(this.subjectID);
		if(affect > 0)
		{
			return this.SUCCESS;
		}
		else
		{
			return this.ERROR;
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

}