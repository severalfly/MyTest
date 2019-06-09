package com.leon.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import com.leon.po.*;
import com.leon.service.*;
import javax.servlet.*;
import com.leon.util.*;


public class SubjectQueryAction extends ActionSupport
{

	private SubjectServiceImpl subjectService = new SubjectServiceImpl();

	public String execute() throws Exception
	{
		Page page = new Page();
		page.setEveryPage(10);
		page.setCurrentPage(0);
		PageResult result = subjectService.queryAllSubjectByPage(page);
		if(result == null)
		{
			return this.ERROR;
		}
		else
		{
			ServletActionContext.getRequest().setAttribute("result", result);
			return this.SUCCESS;
		}
	}

}