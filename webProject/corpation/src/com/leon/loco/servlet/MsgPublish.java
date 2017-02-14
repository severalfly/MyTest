package com.leon.loco.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import java.util.Date;
import com.leon.loco.bean.Message;
import com.leon.loco.bean.Employee;
import com.leon.loco.dao.MessageDAO;
import com.leon.loco.daoImpl.MessageDAOImpl;
import com.leon.loco.factory.MessageDAOFactory;

public class MsgPublish extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if(null == employee)
		{
			request.setAttribute("error", "您未登录");
			request.getRequestDispatcher("/statusRecognise.jsp").forward(request, response);
		}
		else
		{
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			if(null == title || title.equals("") || null == content || "".equals(content))
			{
				request.setAttribute("error", "标题与内容不能为空");
				request.getRequestDispatcher("/publishNewMsg.jsp").forward(request, response);
			}
			else 
			{
				Message message = new Message();
				message.setEmployeeID(employee.getEmployeeID());
				message.setMessageTitle(title);
				message.setMessageContent(content);
				message.setPublishTime(new Date());	
				MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
				int affect = messageDAO.addMessage(message);
				if(affect > 0) // 添加消息成功
				{
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
				else // 添加失败
				{
					request.setAttribute("error", "添加失败，请重试！！");
					request.getRequestDispatcher("/publishNewMsg.jsp").forward(request, response);
				}
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}