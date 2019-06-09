package com.leon.service;
import com.leon.dao.*;
import java.util.*;
import com.leon.po.*;



public class StudentServiceImpl
{
	private final StudentDAOImpl studentDAO = new StudentDAOImpl();
	public List<Student> getStudentByName(String studentName)
	{
		return studentDAO.findByStudentName(studentName);
	}

	public List<Student> getStudentByClass(String sclass)
	{
		return studentDAO.findByStudentClass(sclass);
	}

	public boolean allowLogin(String studentID, String password)
	{
		if(password == null || "".equals(password))
		{
			return false;
		}
		Student student = studentDAO.findByStudentID(studentID);
		if(student == null)
		{
			return false;
		}
		else if(password.equals(student.getPassword()))
		{
			return true;
		}
		else {
			return false;
		}
	}

	public Student getStudentInfo(String studentID)
	{
		return null;
	}
}