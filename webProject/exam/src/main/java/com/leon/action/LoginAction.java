package com.leon.action;

import java.util.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import com.leon.service.*;
import com.leon.po.*;


public class LoginAction extends ActionSupport
{
	private String id;
	private String password;
	private String role;
	private StudentServiceImpl studentService = new StudentServiceImpl();
	// private TeacherServiceImpl teacherService = new TeacherServiceImpl();
	@Override
	public String execute()
	{
		if("student".equalsIgnoreCase(this.role))
		{
			System.out.println("login action " + id);
			if(studentService.allowLogin(id, password))
			{
				Student studentInfo = studentService.getStudentInfo(id);
				// 保存学生登录记录到session 范围
				Map session = ServletActionContext.getContext().getSession();
				session.put("studentInfo", studentInfo);
				return "studentSuccess";
			}
			else
			{
				return INPUT;
			}
		}
		else if("teacher".equalsIgnoreCase(this.role))
		{
			System.out.println("teacher");
		}
		else
		{
			System.out.println("login action error");
		}
		return SUCCESS;
	}
	public String getId()
	{
		return this.id;
	}
	public void setId(String id)
	{
		this.id = id;
	}

	public String getPassword()
	{
		return this.password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getRole()
	{
		return this.role;
	}
	public void setRole(String role)
	{
		this.role = role;
	}
}