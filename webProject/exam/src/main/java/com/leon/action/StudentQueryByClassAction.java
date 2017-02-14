package com.leon.action;
import java.util.*;
import com.leon.po.*;
import com.leon.service.*;
import com.leon.dao.*;
import javax.servlet.http.*;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;



public class StudentQueryByClassAction extends ActionSupport
{
	private String sclass;
	private StudentServiceImpl studentService = new StudentServiceImpl();

	public String execute()throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Student> students = studentService.getStudentByClass(this.sclass);
		request.setAttribute("students", students);
		return this.SUCCESS;
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