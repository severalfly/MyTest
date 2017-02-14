package com.leon.loco.daoImpl;
import com.leon.loco.dao.EmployeeDAO;
import com.leon.loco.bean.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import com.leon.loco.util.DBConnection;


public class EmployeeDAOImpl implements EmployeeDAO
{
	public void addEmployee(Employee employee)
	{

	}
	public void updateEmployee(Employee employee)
	{

	}
	public void deleteEmployee(int employeeID)
	{

	}
	public List<Employee> findAllEmployee()
	{
		return null;
	}
	public Employee findEmployeeByID(int employeeID)
	{
		Connection conn = DBConnection.getConnection();
		String sql = "select id, name, create_time, password,isLeader from tb_employee where id = ?";
		PreparedStatement pStat = null;
		ResultSet rs = null;
		Employee employee = null;
		try
		{
			pStat = conn.prepareStatement(sql);
			pStat.setObject(1, employeeID);
			rs = pStat.executeQuery();
			if(rs.next())
			{
				employee = new Employee();
				employee.setEmployeeID(rs.getInt(1));
				employee.setEmployeeName(rs.getString(2));
				employee.setJoinTime(rs.getDate(3));
				employee.setPassword(rs.getString(4));
				employee.setIsLead(rs.getBoolean(5));
				return employee;
			}
		}
		catch (SQLException e) {
			
		}
		return null;
	}
}