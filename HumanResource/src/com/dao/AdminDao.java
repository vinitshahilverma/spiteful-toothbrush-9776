package com.dao;

import java.util.List;

import com.bean.Department;
import com.bean.Employee;
import com.bean.FullDeatilsOfemployees;
import com.bean.Leave;
import com.exception.AdminException;
import com.exception.DepartmentException;
import com.exception.LeaveException;
import com.exception.employeeException;

public interface AdminDao {

	public String LoginAdmin(String email, String password) throws AdminException;

	public String registerEmployee(Employee employee) throws DepartmentException;

	public String LoginEmployee(String email, String password) throws employeeException;

	public String addDepartment(Department department);

	public List<Department> showDepartment() throws DepartmentException;

	public String updateEmployeeDepartment(int id, String name, int deptId)
			throws employeeException, DepartmentException;

	public String updateLeaveStatus(int id, String status) throws employeeException;

	public FullDeatilsOfemployees viewDetails(String email, String password) throws employeeException;

	public String changePassword(String name, int id, String newPassword) throws employeeException;

	public String changeEmail(String name, int id, String newEmail) throws employeeException;

	public String changeName(String email, int id, String newName) throws employeeException;

	public String ApplyLeave(int eid, String name, int days) throws employeeException;

	public List<Leave> showEmployeeLeave() throws LeaveException;

	public Leave showYourLeave(int id, String name) throws employeeException, LeaveException;

	public List<FullDeatilsOfemployees> showFullList() throws employeeException;

}
