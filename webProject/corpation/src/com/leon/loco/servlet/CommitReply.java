package com.leon.loco.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import com.leon.loco.bean.Reply;
import com.leon.loco.bean.Employee;
import com.leon.loco.dao.ReplyDAO;
import com.leon.loco.factory.ReplyDAOFactory;

import java.util.Date;

public class CommitReply extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		String messageIDStr = request.getParameter("messageID");
		String replyContent = request.getParameter("replyContent");
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if(null == employee)
		{
			request.setAttribute("error", "请登录");
			request.getRequestDispatcher("/showMsg.jsp").forward(request, response);
		}
		else if(null == messageIDStr || "".equals(messageIDStr))
		{
			request.setAttribute("error", "消息id 为空");
			request.getRequestDispatcher("/showMsg.jsp").forward(request, response);
		}
		else
		{
			Reply reply = new Reply();
			reply.setReplyContent(replyContent);
			reply.setMessageID(Integer.parseInt(messageIDStr));
			reply.setEmployeeID(employee.getEmployeeID());
			reply.setReplyTime(new Date());
			ReplyDAO replyDAO = ReplyDAOFactory.getReplyDAOInstance();
			int affect = replyDAO.addReply(reply);
			if(affect > 0)
			{
				// 添加成功
				request.setAttribute("messageID", messageIDStr);
				request.getRequestDispatcher("/servlet/GetMessage").forward(request, response);
			}
			else
			{
				// 添加失败
				request.setAttribute("error", "添加失败");
				request.setAttribute("messageID", messageIDStr);
				request.getRequestDispatcher("/servlet/GetMessage").forward(request, response);
			}
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}