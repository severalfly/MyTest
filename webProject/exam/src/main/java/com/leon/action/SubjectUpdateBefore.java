package com.leon.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import com.leon.po.*;
import com.leon.service.*;
import javax.servlet.*;


public class SubjectUpdateBefore extends ActionSupport
{
	private int subjectID;

	private SubjectServiceImpl subjectService = new SubjectServiceImpl();

	public String execute() throws Exception
	{
		Subject subject = subjectService.showSubjectParticular(this.subjectID);
		ServletActionContext.getRequest().setAttribute("subject", subject);
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

}