package com.leon.loco.servlet;

import com.leon.loco.util.Page;
import com.leon.loco.util.PageUtil;

import com.leon.loco.dao.MessageDAO;
import com.leon.loco.factory.MessageDAOFactory;

import com.leon.loco.bean.Message;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.List;



public class GetMessageList extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String currentPageStr = request.getParameter("currentPage");
		MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
		int currentPage = 0;
		if(null == currentPageStr || "".equals(currentPageStr))
		{
			currentPage =1;
		}
		else
		{
			currentPage = Integer.parseInt(currentPageStr);
		}
		Page page = PageUtil.createPage(10, messageDAO.findAllCount(), currentPage);
		List<Message> list = messageDAO.findAllMessage(page);
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/msgList.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
  
}