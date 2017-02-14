package com.leon.loco.servlet;

import java.util.List;

import com.leon.loco.dao.MessageDAO;
import com.leon.loco.dao.ReplyDAO;
import com.leon.loco.factory.MessageDAOFactory;
import com.leon.loco.factory.ReplyDAOFactory;


import com.leon.loco.bean.Message;
import com.leon.loco.bean.Reply;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;


import java.io.IOException;



public class GetMessage extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String messageIDStr = request.getParameter("messageID");
		if(null == messageIDStr || "".equals(messageIDStr))
		{
			request.setAttribute("error", "消息id 为空");
			request.getRequestDispatcher("/showMsg.jsp").forward(request, response);
			return;
		}
		int messageID = Integer.parseInt(messageIDStr);
		MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
		ReplyDAO replyDAO = ReplyDAOFactory.getReplyDAOInstance();
		Message message = messageDAO.findMessageById(messageID);
		List<Reply> replyes = replyDAO.findReplyByMessageID(messageID);
		request.setAttribute("replyes", replyes);
		request.setAttribute("message", message);
		request.getRequestDispatcher("/showMsg.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}


}