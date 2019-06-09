package com.leon.loco.daoImpl;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.leon.loco.bean.Vote;
import com.leon.loco.dao.VoteDAO;

import com.leon.loco.util.DBConnection;
import com.leon.loco.util.ObjectUtils;
import com.leon.loco.util.Page;

public class VoteDAOImpl implements VoteDAO
{
	public int addVote(Vote vote)
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into tb_vote(voteName, channelID, create_time) value(?,?,CURRENT_TIMESTAMP)";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vote.getVoteName());
			pstmt.setInt(2, vote.getChannelID());
			int affect = pstmt.executeUpdate();
			return affect;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();	
		}
		return 0;
	}
	public Vote findVoteByID(int voteID)
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select voteId, voteName, channeclID from tb_vote where voteID = ?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, voteID);
			
			rs = pstmt.executeQuery();
			Vote vote = new Vote();
			if(rs.next())
			{
				vote.setVoteID(rs.getInt(1));
				vote.setVoteName(rs.getString(2));
				vote.setChannelID(rs.getInt(3));
				return vote;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();	
		}
		return null;
	}


	public Vote findVoteByName(String voteName)
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select voteId, voteName, channeclID from tb_vote where voteName= ?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, voteName);
			
			rs = pstmt.executeQuery();
			Vote vote = new Vote();
			if(rs.next())
			{
				vote.setVoteID(rs.getInt(1));
				vote.setVoteName(rs.getString(2));
				vote.setChannelID(rs.getInt(3));
				return vote;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();	
		}
		return null;
	}

	public int findVoteIDByName(String voteName)
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select voteId from tb_vote where voteName= ?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, voteName);
			
			rs = pstmt.executeQuery();
			Vote vote = new Vote();
			if(rs.next())
			{
				return rs.getInt(1);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();	
		}
		return 0;
	}

	public int findAllCount()
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from tb_vote ";
		try
		{
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			Vote vote = new Vote();
			if(rs.next())
			{
				return rs.getInt(1);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();	
		}
		return 0;
	}

	public List<Vote> findAllPage(Page page)
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select voteID, voteName, channelID from tb_vote limit ?,?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page.getBeginIndex());
			pstmt.setInt(2, page.getEveryPage());
			rs = pstmt.executeQuery();
			List<Vote> result = new ArrayList<Vote>();
			while (rs.next())
			{
				Vote vote = new Vote();
				vote.setVoteID(rs.getInt(1));
				vote.setVoteName(rs.getString(2));
				vote.setChannelID(rs.getInt(3));
				result.add(vote);
			}
			return result;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();	
		}
		return new ArrayList<Vote>(0);
	}


	public int deleteVoteByID(int voteID)
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "delete from tb_vote where voteID = ?";
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

	public int findCountByChannelID(int channelID)
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from tb_vote where channelID = ?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, channelID);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				return ObjectUtils.getInt(rs.getInt(1));
			}
			return 0;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();	
		}
		return 0;
	}

	public List<Vote> findVotesByChannelID(Page page, int channelID)
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select voteID, voteName, channelID from tb_vote where channelID = ? limit ?,?";
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, channelID);
			pstmt.setInt(2, page.getBeginIndex());
			pstmt.setInt(3, page.getEveryPage());
			rs = pstmt.executeQuery();
			List<Vote> result = new ArrayList<Vote>();
			while (rs.next())
			{
				Vote vote = new Vote();
				vote.setVoteID(rs.getInt(1));
				vote.setVoteName(rs.getString(2));
				vote.setChannelID(rs.getInt(3));
				result.add(vote);
			}
			return result;
		}
		catch (SQLException e) 
		{
			e.printStackTrace();	
		}
		return new ArrayList<Vote>(0);
	}
}