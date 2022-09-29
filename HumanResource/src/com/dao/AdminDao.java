package com.dao;

import java.util.List;

import com.bean.Department;
import com.bean.Employee;
import com.exception.AdminException;
import com.exception.employeeException;

public interface AdminDao {
	
	public String LoginAdmin(String email,String password)throws AdminException;
	
	public String registerEmployee(Employee employee);
	
	public String LoginEmployee(String email,String password)throws employeeException;
	
	public String addDepartment(Department department);
	
	public List<Department> showDepartment();
	
	public String updateEmployeeDepartment(int id,int name,int deptId)throws employeeException;
	
	public String updateLeaveStatus(int id);
	
    public Employee viewDetails(int id,String password)throws employeeException;
	
	public String changePassword(String email,String oldpassword,String newPassword)throws employeeException;
	
	public String ApplyLeave(int days);

}
