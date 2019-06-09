package com.leon.service;

import com.leon.dao.*;
import com.leon.po.*;
import com.leon.util.*;
import java.util.*;

/**
 * service layout
 */
public class SubjectServiceImpl
{
	private SubjectDAOImpl subjectDAO = new SubjectDAOImpl();
	/**
	 * @param
	 * @return
	 */
	public boolean saveSubject(Subject subject)
	{
		String subjectTitle = subject.getSubjectTitle();// 获取试题题目
		if(subjectDAO.findSubjectByTitle(subjectTitle) == null)
		{
			subjectDAO.addSubject(subject);
			return true;
		}
		else
		{
			return false;
		}
	}

	public Subject showSubjectParticular(int subjectID)
	{
		return subjectDAO.findSubjectByID(subjectID);
	}

	public int updateSubject(Subject subject)
	{
		return subjectDAO.updateSubject(subject);
	}

	public int deleteSubject(int subjectID)
	{
		return subjectDAO.deleteSubject(subjectID);
	}

	public PageResult likeQueryBySubjectTitle(String subjectTitle, Page page)
	{
		page = PageUtil.createPage(page.getEveryPage(), subjectDAO.findLinkQueryCount(subjectTitle), page.getCurrentPage());
		List<Subject> list = subjectDAO.likeQueryByTitle(subjectTitle, page);
		PageResult result = new PageResult(page, list);
		return result;
	}

	public PageResult queryAllSubjectByPage(Page page)
	{
		page = PageUtil.createPage(page.getEveryPage(), subjectDAO.findQueryCount(), page.getCurrentPage());
		List<Subject> list = subjectDAO.queryByPage(page);
		PageResult result = new PageResult(page, list);
		return result;
	}

	public List<Subject> randomFindSubject(int number)
	{
		return this.subjectDAO.randomFindSubject(number);
	}

}