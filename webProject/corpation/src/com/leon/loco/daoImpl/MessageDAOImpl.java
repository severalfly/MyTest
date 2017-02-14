package com.leon.loco.daoImpl;

import com.leon.loco.bean.Message;
import com.leon.loco.util.Page;
import com.leon.loco.dao.MessageDAO;
import com.leon.loco.util.DBConnection;

import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class MessageDAOImpl implements MessageDAO
{
	public int addMessage(Message message)
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pStat = null;
		ResultSet rs = null;
		String sql = "insert into tb_message(id, title, content, employee_id, publish_time) value(?,?,?,?,CURRENT_TIMESTAMP)";
		try
		{
			pStat = conn.prepareStatement(sql);
			pStat.setInt(1, message.getMessageID());
			pStat.setString(2, message.getMessageTitle());
			pStat.setString(3, message.getMessageContent());
			pStat.setInt(4, message.getEmployeeID());
			int affect = pStat.executeUpdate();
			return affect;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return 0;
	}
	public int updateMessage(Message message)
	{
		return 0;
	}
	public int deleteMessage(int messageID)
	{
		return 0;
	}
	public List<Message> findAllMessage(Page page)
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pStat = null;
		ResultSet rs = null;
		String sql = "select id, title, content, employee_id, publish_time from tb_message order by publish_time limit ?,?";
		try
		{
			pStat = conn.prepareStatement(sql);
			pStat.setInt(1, page.getBeginIndex());
			pStat.setInt(2, page.getEveryPage());
			rs = pStat.executeQuery();
			List<Message> result = new ArrayList<Message>();
			while(rs.next())
			{
				Message message = new Message();
				message.setMessageID(rs.getInt(1));
				message.setMessageTitle(rs.getString(2));
				message.setMessageContent(rs.getString(3));
				message.setEmployeeID(rs.getInt(4));
				message.setPublishTime(rs.getDate(5));
				result.add(message);
			}
			return result;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return new ArrayList<Message>(0);
	}
	public Message findMessageById(int messageID)
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pStat = null;
		ResultSet rs = null;
		String sql = "select id, title, content, employee_id, publish_time from tb_message where id = ?";
		try
		{
			pStat = conn.prepareStatement(sql);
			pStat.setInt(1, messageID);
			rs = pStat.executeQuery();

			if(rs.next())
			{
				Message message = new Message();
				message.setMessageID(rs.getInt(1));
				message.setMessageTitle(rs.getString(2));
				message.setMessageContent(rs.getString(3));
				message.setEmployeeID(rs.getInt(4));
				message.setPublishTime(rs.getDate(5));
				
				return message;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	public int findAllCount()
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pStat = null;
		ResultSet rs = null;
		String sql = "select count(*) from tb_message ";
		try
		{
			pStat = conn.prepareStatement(sql);
			rs = pStat.executeQuery();

			if(rs.next())
			{
				return rs.getInt(1);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return 0;
	}
}