package com.leon.loco.dao;
import com.leon.loco.bean.Employee;
import java.util.List;

public interface EmployeeDAO 
{
	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(int employeeID);
	public List<Employee> findAllEmployee();
	public Employee findEmployeeByID(int employeeID);
}