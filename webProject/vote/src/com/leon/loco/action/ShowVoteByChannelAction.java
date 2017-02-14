package com.leon.loco.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.leon.loco.bean.Vote;
import com.leon.loco.util.Page;
import com.leon.loco.util.PageUtil;

import com.leon.loco.dao.VoteDAO;
import com.leon.loco.factory.VoteDAOFactory;

import com.leon.loco.dao.VoteOptionDAO;
import com.leon.loco.factory.VoteOptionDAOFactory;

import com.leon.loco.util.ObjectUtils;
import org.apache.log4j.Logger;



public class ShowVoteByChannelAction extends ActionSupport
{
	private static Logger logger = Logger.getLogger("com.leon.loco.action");
	private int channelID;
	private int currentPage;


	public String execute() throws Exception
	{
		logger.error("test");
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
		VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
		int allCount = voteDAO.findCountByChannelID(this.channelID);
		Page page = PageUtil.createPage(10, allCount, currentPage);
		List<Vote> votes =  voteDAO.findVotesByChannelID(page, this.channelID);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("votes", votes);
		return this.SUCCESS;
	}

	public int getChannelID()
	{
		return this.channelID;
	}
	public void setChannelID(int channelID)
	{
		this.channelID = channelID;
	}

	public int getCurrentPage()
	{
		return this.currentPage;
	}
	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}
}