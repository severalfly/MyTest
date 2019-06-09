package com.leon.action;


import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.*;
import org.apache.struts2.ServletActionContext;

import com.leon.po.*;
import com.leon.service.*;
import java.util.*;


public class GetRandomSubject extends ActionSupport
{
	private static final SubjectServiceImpl subjectService = new SubjectServiceImpl();
	@Override
	public String execute() throws Exception
	{
		List<Subject> list = subjectService.randomFindSubject(10);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("subjects", list);
		return this.SUCCESS;
	}
}