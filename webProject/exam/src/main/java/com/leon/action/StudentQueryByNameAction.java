package com.leon.action;
import com.leon.po.*;
import com.leon.service.*;
import java.util.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import javax.servlet.*;
import javax.servlet.http.*;



public class StudentQueryByNameAction extends ActionSupport
{
	private StudentServiceImpl studentService = new StudentServiceImpl();
	private String studentName;
	public String execute() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Student> students = studentService.getStudentByName(this.studentName);
		System.out.println(students.size());
		request.setAttribute("students", students);
		return this.SUCCESS;
	}
	public String getStudentName()
	{
		return this.studentName;
	}
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}
}