package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Department;
import com.bean.Employee;
import com.exception.AdminException;
import com.exception.DepartmentException;
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
				
				message = "Welcome " + n;
				
			}
			else {
				throw new AdminException("Wrong Credentials");
			}
			
		}catch(SQLException e){
			
			throw new AdminException(e.getMessage());
		}

		return message;
		
	}

	@Override
	public String registerEmployee(Employee employee) {
		
	       String message = "Employee not regestered...";
	       
	       try(Connection conn = DBUtil.provideConnection()){
	    	   
	    	   PreparedStatement ps = conn.prepareStatement
	    			   ("insert into employee (ename,email,password,deptId) values(?,?,?,?)");
	    	   
	    	   ps.setString(1,employee.getName());
	    	   ps.setString(2,employee.getEmail());
	    	   ps.setString(3,employee.getPassword());
	    	   ps.setInt(4, employee.getDepartment());
	    	   
	    	   int x = ps.executeUpdate();
	    	   
	    	   if(x>0) {
	    		   message = "Employee registerd successfully";
	    	   }
	    	   
	       }catch(SQLException e){
	    	   e.getMessage();
	       }
	       
	       return message;
	}

	@Override
	public String LoginEmployee(String email, String password) throws employeeException {
		String message = "Wrong Credentials";
		
		try(Connection conn = DBUtil.provideConnection()){

			PreparedStatement ps = conn.prepareStatement
					("Select * from employee where email=? AND password = ?");
			
			 ps.setString(1, email);
			 ps.setString(2,password);
			 
			 ResultSet rs = ps.executeQuery();
			 
			 if(rs!=null) {
				 
				 String name = rs.getString("ename");
				 
				 message = "Welcome " + name;
				 
			 }
			 else {
				 
				 throw new employeeException("Wrong Credentials");
				 
			 }
				
			}catch(SQLException e) {
							
				throw new employeeException(e.getMessage());
				
			}
		
		return message;
	}
	
	

	@Override
	public String addDepartment(Department department) {
		  
		String message = "Not Inserted...";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement
					("Insert into insert into department values(?,?,?)");
			
			ps.setInt(1, department.getId());
			ps.setString(2,department.getDname());
			ps.setString(3,department.getLocation());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "New Department Added..";
			}
			
			
		}catch(SQLException se) {
			se.getMessage();
		}
 
		return message;
	}

	@Override
	public List<Department> showDepartment()throws DepartmentException {
		
		List<Department> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement
					("Select * from Department");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs!=null) {
				
				int deptId = rs.getInt("deptId");
				String dname = rs.getString("dname");
				String dlocation = rs.getString("dlocation");
				
				list.add(new Department(deptId,dname,dlocation));
				
			}
				
			}catch(SQLException e) {
				
				throw new DepartmentException(e.getMessage());
				
			}
			
		if(list.size()==0) {
			throw new DepartmentException("No Department found");
		}

		return list;
	}

	@Override
	public String updateEmployeeDepartment(int id, int name, int deptId) throws employeeException {
		String message = "department not changed";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			  PreparedStatement ps = conn.prepareStatement
					  ("update employee set deptId = ? where ename = ? AND eid=?");
			  
			  int x = ps.executeUpdate();
			  
			  if(x>0) {
				  message = name+"'s department Updated successfully";
			  }
			  else {
				  throw new employeeException("Wrong Input..");
			  }
			
		}catch(SQLException se) {
			
		   throw new employeeException(se.getMessage());
			
		}
		
		return message;
	}

	@Override
	public String updateLeaveStatus(int id,String status)throws employeeException{
		
		String message = "Employee not found";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement
					("update leave_status set leaveStatus =? where eid = ?");
			
			ps.setString(1,status);
			ps.setInt(2, id);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				message = "Leave status update Successfully..";
			}
			
		}catch(SQLException e) {
			throw new employeeException(e.getMessage());
		}
		
		return message;
		
	}

	@Override
	public Employee viewDetails(String email, String password) throws employeeException {
		
		Employee employee;
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement
					("Select * from employee where email=? AND password=?");
			
			ResultSet rs = ps.executeQuery();
			
			if(rs!=null) {
		         int id = rs.getInt("eid");
		         String ename = rs.getString("ename");
		         String e = rs.getString("email");
		         String p = rs.getString("password");
		         int did = rs.getInt("deptId");
		         
                 employee = new Employee(id,ename,e,p,did);    
			}
			else {
				  throw new employeeException("Employee not found...");
			}
		}catch(SQLException e) {
			
			throw new employeeException(e.getMessage());
		}
		
		
		return employee;
	}

	@Override
	public String changePassword(String email, int eid, String newPassword) throws employeeException {
		
		String message  = "Employee not found";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement
					("update employee set password = ? where ename = ? AND Eid = ?;");
			
		    int x = ps.executeUpdate();
		    
		    if(x > 0) {
		    	message = "Password updated successfuly"; 
		    }
			
		}catch(SQLException se) {
			
			throw new employeeException(se.getMessage());
		}
		
		
		return message;
	}

	@Override
	public String ApplyLeave(int eid,String name,int days)throws employeeException{
		String message = "Failed to apply leave";
		
	     try(Connection conn = DBUtil.provideConnection()){
	    	 
	    	 PreparedStatement ps  = conn.prepareStatement
	    			 ("insert into leave_status values (?,?,?,'applied')");
	    	 
	    	 ps.setInt(1,eid);
	    	 ps.setString(2,name);
	    	 ps.setInt(3,days);
	    	 
	    	 int x = ps.executeUpdate();
	    	 
	    	 if(x>0) {
	    		 message = "Leave applied successfully..";
	    	 }
	    	 else {
	    		 throw new employeeException("Employee not found");
	    	 }
	     }catch(SQLException e) { 
	    	 throw new employeeException(e.getMessage()); 
	     }
		
		
		return message;
	}
	
	

}
