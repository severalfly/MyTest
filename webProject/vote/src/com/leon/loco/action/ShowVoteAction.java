package com.leon.loco.action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.leon.loco.util.Page;
import com.leon.loco.util.PageUtil;

import com.leon.loco.bean.Vote;
import com.leon.loco.bean.VoteOption;
import com.leon.loco.bean.VoteResult;

import com.leon.loco.dao.VoteDAO;
import com.leon.loco.dao.VoteOptionDAO;

import com.leon.loco.factory.VoteDAOFactory;
import com.leon.loco.factory.VoteOptionDAOFactory;


public class ShowVoteAction extends ActionSupport
{
	int currentPage;
	public int getCurrentPage()
	{
		return this.currentPage;
	}
	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}

	public String execute() throws Exception
	{
		System.out.println("test");
		VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
		VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
		int allCount = voteDAO.findAllCount();
		Page page = PageUtil.createPage(10, allCount, this.currentPage);
		List<Vote> votes = voteDAO.findAllPage(page);
		List<VoteResult> result = new ArrayList<VoteResult>(votes.size());
		for (Vote vote : votes) {
			VoteResult voteResult = new VoteResult();
			voteResult.setVote(vote);
			List<VoteOption> vps = voteOptionDAO.findVoteOptionByVoteID(vote.getVoteID());
			voteResult.setVoteOptions(vps);
			result.add(voteResult);
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("voteResultList", result);

		return this.SUCCESS;
	}
}