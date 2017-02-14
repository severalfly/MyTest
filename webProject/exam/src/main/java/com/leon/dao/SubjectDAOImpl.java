package com.leon.dao;
import com.leon.po.*;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import com.leon.util.*;
import com.leon.hibernate.*;
import java.sql.*;


public class SubjectDAOImpl
{
	/**
	 * 获取Session
	 * @return
	 */
	// private Session getSession()
	// {
	// 	Configuration config = new Configuration().configure();
	// 	SessionFactory sessionFactory = config.buildSessionFactory();
	// 	return sessionFactory.openSession();
	// }
	/**
	* 根据Title 查找
	*/
	public Subject findSubjectByTitle(String subjectTitle)
	{
		System.out.println("test 0");
		Connection conn = null;
		try
		{
			conn = DBConnection.getConnection();
			PreparedStatement select = conn.prepareStatement("select subject_id,subject_title,subject_option_a,subject_option_b,subject_option_c,subject_option_d,subject_answer,subject_parse from tb_subject where subject_title = ?");
			select.setString(1, subjectTitle);
			ResultSet rs = select.executeQuery();
			Subject subject = new Subject();
			if(rs.next())
			{
				subject.setSubjectID(rs.getInt(1));
				subject.setSubjectTitle(rs.getString(2));
				subject.setSubjectOptionA(rs.getString(3));
				subject.setSubjectOptionB(rs.getString(4));
				subject.setSubjectOptionC(rs.getString(5));
				subject.setSubjectOptionD(rs.getString(6));
				subject.setSubjectAnswer(rs.getString(7));
				subject.setSubjectParse(rs.getString(8));
				return subject;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	/** 
	 * 添加一条记录
	 * @param
	 */
	public void addSubject(Subject subject)
	{
		// Connection conn = null;
		// PreparedStatement pStat = null;
		// try
		// {
		// 	conn = DBConnection.getConnection();
		// 	pStat = conn.prepareStatement("insert into tb_subject( subject_title,subject_option_a,subject_option_b,subject_option_c,subject_option_d,subject_answer,subject_parse) value(?,?,?,?,?,?,?)");
		// 	pStat.setString(1, subject.getSubjectTitle());
		// 	pStat.setString(2, subject.getSubjectOptionA());
		// 	pStat.setString(3, subject.getSubjectOptionB());
		// 	pStat.setString(4, subject.getSubjectOptionC());
		// 	pStat.setString(5, subject.getSubjectOptionD());
		// 	pStat.setString(6, subject.getSubjectAnswer());
		// 	pStat.setString(7, subject.getSubjectParse());
		// 	int affect = pStat.executeUpdate();
		// }
		// catch (Exception e) {
		// 	e.printStackTrace();
		// }
		// finally
		// {
		// 	DBConnection.close(conn);
		// 	DBConnection.close(pStat);
		// }
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try
		{
			transaction = session.beginTransaction();
			session.save(subject);
			transaction.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
		}
		HibernateSessionFactory.closeSession();
	}

	/**
	 * 根据试题id 查询
	 * @param 试题id
	 * @return 试题
	 */
	public Subject findSubjectByID(int subjectID)
	{
		// Connection conn = null;
		// try
		// {
		// 	conn = DBConnection.getConnection();
		// 	PreparedStatement select = conn.prepareStatement("select subject_id,subject_title,subject_option_a,subject_option_b,subject_option_c,subject_option_d,subject_answer,subject_parse from tb_subject where subject_id = ?");
		// 	select.setInt(1, subjectID);
		// 	ResultSet rs = select.executeQuery();
		// 	Subject subject = new Subject();
		// 	if(rs.next())
		// 	{
		// 		subject.setSubjectID(rs.getInt(1));
		// 		subject.setSubjectTitle(rs.getString(2));
		// 		subject.setSubjectOptionA(rs.getString(3));
		// 		subject.setSubjectOptionB(rs.getString(4));
		// 		subject.setSubjectOptionC(rs.getString(5));
		// 		subject.setSubjectOptionD(rs.getString(6));
		// 		subject.setSubjectAnswer(rs.getString(7));
		// 		subject.setSubjectParse(rs.getString(8));
		// 		System.out.println("find subject by id success " + subject.getSubjectTitle());
		// 		System.out.println(subject);
		// 		return subject;
		// 	}
		// }
		// catch (Exception e)
		// {
		// 	e.printStackTrace();
		// }
		// System.out.println("find subject by id failed");
		// return null;
		Session session = HibernateSessionFactory.getSession();
		Subject subject = (Subject)session.get(Subject.class, subjectID);
		System.out.println("find subject by id success " + subject.getSubjectTitle());
		HibernateSessionFactory.closeSession();
		return subject;
	}

	/**
	 * 更新试题
	 * @param
	 */
	public int  updateSubject(Subject subject)
	{
		// Connection conn = null;
		// PreparedStatement pStat = null;
		// try
		// {
		// 	conn = DBConnection.getConnection();
		// 	pStat = conn.prepareStatement("update tb_subject set subject_title = ?, subject_option_a = ?, subject_option_b = ?,subject_option_c = ?,subject_option_d = ?, subject_answer = ?, subject_parse = ?");
		// 	pStat.setString(1, subject.getSubjectTitle());
		// 	pStat.setString(2, subject.getSubjectOptionA());
		// 	pStat.setString(3, subject.getSubjectOptionB());
		// 	pStat.setString(4, subject.getSubjectOptionC());
		// 	pStat.setString(5, subject.getSubjectOptionD());
		// 	pStat.setString(6, subject.getSubjectAnswer());
		// 	pStat.setString(7, subject.getSubjectParse());
		// 	int affect = pStat.executeUpdate();
		// 	System.out.println("update subject success");
		// 	return affect;
		// }
		// catch (Exception e) {
		// 	e.printStackTrace();
		// }
		// finally
		// {
		// 	DBConnection.close(conn);
		// 	DBConnection.close(pStat);
		// }
		// System.out.println("update subject failed");
		// return 0;
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = null;
		try
		{
			transaction = session.beginTransaction();
			session.update(subject);
			transaction.commit();
			return 1;
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		return 0;
	}


	public int deleteSubject(int subjectID)
	{
		Connection conn = null;
		PreparedStatement pStat = null;
		try
		{
			conn = DBConnection.getConnection();
			pStat = conn.prepareStatement("delete from tb_subject where subject_id = ?");
			pStat.setInt(1, subjectID);
			int affect = pStat.executeUpdate();
			return affect;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			DBConnection.close(conn);
			DBConnection.close(pStat);
		}
		return 0;
	}


	/**
	 * 模糊搜索
	 * @param subjectTitle 搜索关键字
	 * @return 相关个数
	 */
	public int findLinkQueryCount(String subjectTitle)
	{
		Connection conn = null;
		PreparedStatement pStat = null;
		try
		{
			conn = DBConnection.getConnection();
			pStat = conn.prepareStatement("select count(*) as cnt from tb_subject where subject_title = ?");
			pStat.setString(1, subjectTitle);
			ResultSet rs = pStat.executeQuery();
			if(rs.next())
			{
				return rs.getInt("cnt");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			DBConnection.close(conn);
			DBConnection.close(pStat);
		}
		return 0;
	}

/**
	 * 模糊搜索
	 * @param subjectTitle 搜索关键字
	 * @return 相关个数
	 */
	public int findQueryCount()
	{
		// Connection conn = null;
		// PreparedStatement pStat = null;
		// try
		// {
		// 	conn = DBConnection.getConnection();
		// 	pStat = conn.prepareStatement("select count(*) as cnt from tb_subject");
		// 	ResultSet rs = pStat.executeQuery();
		// 	if(rs.next())
		// 	{
		// 		return rs.getInt("cnt");
		// 	}
		// }
		// catch (Exception e) {
		// 	e.printStackTrace();
		// }
		// finally
		// {
		// 	DBConnection.close(conn);
		// 	DBConnection.close(pStat);
		// }
		// return 0;
		Session session = HibernateSessionFactory.getSession();
		try
		{
			Query query = session.createQuery("from Subject as subject");
			List<Subject> list = query.list();
			return list.size();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Subject> likeQueryByTitle(String subjectTitle, Page page)
	{
		// Connection conn = null;
		// PreparedStatement select = null;
		// ResultSet rs = null;
		// List<Subject> list = new ArrayList<Subject>();
		// try
		// {
		// 	conn = DBConnection.getConnection();
		// 	select = conn.prepareStatement("select subject_id,subject_title,subject_option_a,subject_option_b,subject_option_c,subject_option_d,subject_answer,subject_parse from tb_subject where subject_title like ? limit ?,?");
		// 	select.setString(1, "%" + subjectTitle + "%");
		// 	select.setInt(2, page.getBeginIndex());
		// 	select.setInt(3, page.getEveryPage());
		// 	rs = select.executeQuery();
		// 	Subject subject = new Subject();
		// 	while(rs.next())
		// 	{
		// 		subject.setSubjectID(rs.getInt(1));
		// 		subject.setSubjectTitle(rs.getString(2));
		// 		subject.setSubjectOptionA(rs.getString(3));
		// 		subject.setSubjectOptionB(rs.getString(4));
		// 		subject.setSubjectOptionC(rs.getString(5));
		// 		subject.setSubjectOptionD(rs.getString(6));
		// 		subject.setSubjectAnswer(rs.getString(7));
		// 		subject.setSubjectParse(rs.getString(8));
		// 		list.add(subject);
		// 	}
		// }
		// catch (Exception e)
		// {
		// 	e.printStackTrace();
		// }
		// finally
		// {
		// 	DBConnection.close(conn);
		// 	DBConnection.close(select);
		// 	DBConnection.close(rs);
		// }
		// return list;
		Session session = HibernateSessionFactory.getSession();
		try
		{
			Query query = session.createQuery("from Subject as subject where subject.subject_title like :title");
			query.setString("title", subjectTitle);
			query.setMaxResults(page.getEveryPage());
			query.setFirstResult(page.getBeginIndex());
			List<Subject> list = query.list();
			return list;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Subject>(0);
	}

	public List<Subject> queryByPage(Page page)
	{
		Session session = null;
		Query query = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			query = session.createQuery("from Subject as sub");
			query.setMaxResults(page.getEveryPage());
			query.setFirstResult(page.getBeginIndex());
			List<Subject> result = query.list();
			return result;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			if(session != null)
			{
				session.close();
			}
			
		}
		return null;
	}

	/**
	 * 随机获取试题
	 * @param  number 获取试题个数
	 * @return        获取的主题list
	 */
	public List<Subject> randomFindSubject(int number)
	{
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Subject as sub order by rand()");
		query.setMaxResults(number);
		List<Subject> list = query.list();
		HibernateSessionFactory.closeSession();
		return list;
	}
}