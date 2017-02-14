package com.leon.loco.daoImpl;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;


import com.leon.loco.bean.VoteOption;
import com.leon.loco.dao.VoteOptionDAO;

import com.leon.loco.util.DBConnection;
import com.leon.loco.util.ObjectUtils;



public class VoteOptionDAOImpl implements VoteOptionDAO
{
	public int addVoteOption(VoteOption voteOption)
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into tb_voteoption(voteId, voteOptionID, voteOptionName, ticketNum, create_time) value(?,?,?,?,CURRENT_TIMESTAMP)";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, voteOption.getVoteID());
			pstmt.setInt(2, voteOption.getVoteOptionID());
			pstmt.setString(3, voteOption.getVoteOptionName());
			pstmt.setInt(4, voteOption.getTicketNum());
			int affect = pstmt.executeUpdate();
			return affect;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();	
		}
		return 0;
	}

	public List<VoteOption> findVoteOptionByVoteID(int voteID)
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select voteId, voteOptionID, voteOptionName, ticketNum  from  tb_voteoption where voteID= ?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, voteID);
			rs = pstmt.executeQuery();
			List<VoteOption> result = new ArrayList<VoteOption>();
			while(rs.next())
			{
				VoteOption voteOption = new VoteOption();
				voteOption.setVoteID(rs.getInt(1));
				voteOption.setVoteOptionID(rs.getInt(2));
				voteOption.setVoteOptionName(rs.getString(3));
				voteOption.setTicketNum(rs.getInt(4));
				result.add(voteOption);
			}
			return result;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();	
		}
		return new ArrayList<VoteOption>(0);
	}


	public int deleteVoteByID(int voteID)
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "delete from tb_voteoption where voteID = ?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, voteID);
			int affect = pstmt.executeUpdate();
			return affect;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();	
		}
		return 0;
	}

}