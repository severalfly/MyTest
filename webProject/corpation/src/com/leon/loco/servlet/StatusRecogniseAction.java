package com.leon.loco.servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import com.leon.loco.bean.Employee;
import com.leon.loco.dao.EmployeeDAO;
import com.leon.loco.factory.EmployeeDAOFactory;


public class StatusRecogniseAction extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		String employeeID = request.getParameter("employeeID");
		String password = request.getParameter("password");
		if(null == employeeID || "".equals(employeeID))
		{
			request.setAttribute("error","请输入用户id");
			request.getRequestDispatcher("/statusRecognise.jsp").forward(request, response);
		}
		else if(null == password || "".equals(password))
		{
			request.setAttribute("error","请输入用户密码");
			request.getRequestDispatcher("/statusRecognise.jsp").forward(request, response);
		}
		else
		{
			EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAOInstance();
			Employee employee = employeeDAO.findEmployeeByID(Integer.parseInt(employeeID));
			if (null == employee)
			{
				request.setAttribute("error","用户不存在");
				request.getRequestDispatcher("/statusRecognise.jsp").forward(request, response);
			}
			else if (!password.equals(employee.getPassword())) 
			{
				request.setAttribute("error","用户名密码不匹配");
				request.getRequestDispatcher("/statusRecognise.jsp").forward(request, response);
			}
			else
			{
				request.getSession().setAttribute("employee", employee);
				request.getRequestDispatcher("/index.jsp").forward(request, response);

			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		doGet(request, response);
	}
}