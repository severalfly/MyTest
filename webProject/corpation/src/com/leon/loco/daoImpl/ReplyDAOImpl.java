package com.leon.loco.daoImpl;

import java.util.List;
import java.util.ArrayList;
import com.leon.loco.bean.Reply;
import com.leon.loco.dao.ReplyDAO;
import com.leon.loco.util.DBConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ReplyDAOImpl implements ReplyDAO
{
	public List<Reply> findReplyByMessageID(int messageID)
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pStat = null;
		ResultSet rs = null;
		String sql = "select id, content, employee_id, reply_time, message_id from tb_reply where message_id = ?";
		try
		{
			pStat = conn.prepareStatement(sql);
			pStat.setInt(1, messageID);
			rs = pStat.executeQuery();
			List<Reply> result = new ArrayList<Reply>();
			while(rs.next())
			{
				Reply reply = new Reply();
				reply.setReplyContent(rs.getString(2));
				reply.setEmployeeID(rs.getInt(3));
				reply.setReplyTime(rs.getDate(4));
				reply.setMessageID(rs.getInt(5));
				result.add(reply);
			}
			return result;
		}
		catch (Exception e) 
		{
			e.printStackTrace();	
		}
		return new ArrayList<Reply>(0);
	}
	public int addReply(Reply reply)
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pStat = null;
		String sql = "insert into tb_reply(content, employee_id, reply_time, message_id) value(?,?,CURRENT_TIMESTAMP, ?)";
		try
		{
			pStat = conn.prepareStatement(sql);
			pStat.setString(1, reply.getReplyContent());
			pStat.setInt(2, reply.getEmployeeID());
			pStat.setInt(3, reply.getMessageID());
			int affect = pStat.executeUpdate();
			return affect;
		}
		catch (Exception e) 
		{
			e.printStackTrace();	
		}
		return 0;
	}
}