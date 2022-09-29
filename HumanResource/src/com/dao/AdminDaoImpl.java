package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bean.Department;
import com.bean.Employee;
import com.exception.AdminException;
import com.exception.employeeException;
import com.utility.DBUtil;

public class AdminDaoImpl implements AdminDao{

	@Override
	public String LoginAdmin(String email, String password) throws AdminException {
	        
		String message = "Wrong Credentials";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement
					("Select * from admin where email=? And password=?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				String n = rs.getString("name");
				
				message = "Welcome" + n;
				
			}
			else {
				throw new AdminException("Wrong Credentials");
			}
			
		}catch(SQLException e){
			e.printStackTrace();
			
			throw new AdminException(e.getMessage());
		}

		return message;
		
	}

	@Override
	public String registerEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String LoginEmployee(String email, String password) throws employeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addDepartment(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> showDepartment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateEmployeeDepartment(int id, int name, int deptId) throws employeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateLeaveStatus(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee viewDetails(int id, String password) throws employeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changePassword(String email, String oldpassword, String newPassword) throws employeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ApplyLeave(int days) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
