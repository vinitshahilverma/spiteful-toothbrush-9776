package com.dao;

import java.util.List;

import com.bean.Department;
import com.bean.Employee;
import com.exception.AdminException;
import com.exception.DepartmentException;
import com.exception.employeeException;

public interface AdminDao {
	
	public String LoginAdmin(String email,String password)throws AdminException;
	
	public String registerEmployee(Employee employee);
	
	public String LoginEmployee(String email,String password)throws employeeException;
	
	public String addDepartment(Department department);
	
	public List<Department> showDepartment()throws DepartmentException;
	
	public String updateEmployeeDepartment(int id,int name,int deptId)throws employeeException;
	
	public String updateLeaveStatus(int id,String status)throws employeeException;
	
    public Employee viewDetails(String email,String password)throws employeeException;
	
	public String changePassword(String email,int id,String newPassword)throws employeeException;
	
	public String ApplyLeave(int eid,String name,int days)throws employeeException;

}
