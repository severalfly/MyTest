package com.leon.dao;

import java.util.*;
import com.leon.po.*;
import com.leon.hibernate.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class StudentDAOImpl
{
	/**
	 * 通过姓名查找
	 * @param  studentName 学生姓名
	 * @return             学生列表
	 */
	public List<Student> findByStudentName(String studentName)
	{
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Student as stu where stu.studentName =  ?");
		query.setString(0, studentName);
		List list = query.list();
		HibernateSessionFactory.closeSession();
		return list;
	}

	/**
	 * 通过班级查找
	 * @param  sclass 班级
	 * @return        学生列表
	 */
	public List<Student> findByStudentClass(String sclass)
	{
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Student as stu where stu.sclass = ?");
		query.setString(0, sclass);
		List list = query.list();
		HibernateSessionFactory.closeSession();
		return list;
	}

	/**
	 * 通过学生号查找
	 * @param  studentID 学生编号
	 * @return           学生信息
	 */
	public Student findByStudentID(String studentID)
	{
		if(studentID == null || "".equals(studentID))
		{
			return null;
		}
		Session session = HibernateSessionFactory.getSession();
		Student student = (Student) session.get(Student.class, studentID);
		HibernateSessionFactory.closeSession();
		return student;		
	}

}