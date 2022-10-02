package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import com.bean.Department;
import com.bean.Employee;
import com.bean.FullDeatilsOfemployees;
import com.bean.Leave;
import com.exception.AdminException;
import com.exception.DepartmentException;
import com.exception.LeaveException;
import com.exception.employeeException;
import com.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public String LoginAdmin(String email, String password) throws AdminException {

		String message = "Wrong Credentials";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("Select * from admin where email=? And password=?");

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				String n = rs.getString("name");

				message = "Welcome " + n;

			} else {
				throw new AdminException("Wrong Credentials");
			}

		} catch (SQLException e) {

			throw new AdminException(e.getMessage());
		}

		return message;

	}

	@Override
	public String registerEmployee(Employee employee) throws DepartmentException {

		String message = "Employee not regestered...";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps1 = conn.prepareStatement("select * from department where deptId = ?");
			ps1.setInt(1, employee.getDepartment());

			ResultSet rs = ps1.executeQuery();

			if (rs.next()) {

				PreparedStatement ps = conn
						.prepareStatement("insert into employee (ename,email,password,deptId) values(?,?,?,?)");

				ps.setString(1, employee.getName());
				ps.setString(2, employee.getEmail());
				ps.setString(3, employee.getPassword());
				ps.setInt(4, employee.getDepartment());

				int x = ps.executeUpdate();

				if (x > 0) {
					message = "Employee registerd successfully";
				}
			} else {
				throw new DepartmentException("Department not found..");
			}
		} catch (SQLException e) {
			throw new DepartmentException(e.getMessage());
		}

		return message;
	}

	@Override
	public String LoginEmployee(String email, String password) throws employeeException {
		String message = "Wrong Credentials";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from employee where email=? AND password =?");

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				String name = rs.getString("ename");

				message = "Welcome " + name;

			} else {

				throw new employeeException("Wrong Credentials");

			}

		} catch (SQLException e) {

			throw new employeeException(e.getMessage());

		}

		return message;
	}

	@Override
	public String addDepartment(Department department) {

		String message = "Not Inserted...";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("Insert into department values(?,?,?)");

			ps.setInt(1, department.getId());
			ps.setString(2, department.getDname());
			ps.setString(3, department.getLocation());

			int x = ps.executeUpdate();

			if (x > 0) {
				message = "New Department Added..";
			}

		} catch (SQLException se) {
			se.getMessage();
		}

		return message;
	}

	@Override
	public List<Department> showDepartment() throws DepartmentException {

		List<Department> list = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("Select * from Department");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int deptId = rs.getInt("deptId");
				String dname = rs.getString("dname");
				String dlocation = rs.getString("dlocation");

				list.add(new Department(deptId, dname, dlocation));

			}

		} catch (SQLException e) {

			throw new DepartmentException(e.getMessage());

		}

		if (list.size() == 0) {
			throw new DepartmentException("No Department found");
		}

		return list;
	}

	@Override
	public String updateEmployeeDepartment(int id, String name, int deptId)
			throws employeeException, DepartmentException {
		String message = "department not changed";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("Select * from Department where deptId=?");

			ps.setInt(1, deptId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				PreparedStatement ps1 = conn.prepareStatement("Select * from Employee where ename=? AND eid=?");

				ps1.setString(1, name);
				ps1.setInt(2, id);

				ResultSet rs1 = ps1.executeQuery();

				if (rs1.next()) {

					PreparedStatement ps2 = conn
							.prepareStatement(" update employee set deptid=? where ename =? AND eid=?");

					ps2.setInt(1, deptId);
					ps2.setString(2, name);
					ps2.setInt(3, id);

					int x = ps2.executeUpdate();

					if (x > 0) {
						message = "Department changed successfully";
					}

				} else {
					throw new employeeException("Employee not found...");
				}
			} else {
				throw new DepartmentException("Department Not found...");
			}

		} catch (SQLException e) {
			throw new DepartmentException(e.getMessage());
		}

		return message;
	}

	@Override
	public String updateLeaveStatus(int id, String status) throws employeeException {

		String message = "Employee not found";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update leave_status set leaveStatus =? where eid = ?");

			ps.setString(1, status);
			ps.setInt(2, id);

			int x = ps.executeUpdate();

			if (x > 0) {
				message = "Leave status update Successfully..";
			} else {
				throw new employeeException("Employee not found...");
			}

		} catch (SQLException e) {
			throw new employeeException(e.getMessage());
		}

		return message;

	}

	@Override
	public FullDeatilsOfemployees viewDetails(String email, String password) throws employeeException {

		FullDeatilsOfemployees employee;

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement(
					"select e.eid,e.ename,e.email,e.password,e.deptid,d.dname,d.dlocation from employee e  Inner Join department d ON e.deptId=d.deptId where email = ? AND password =?");

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				int id = rs.getInt("eid");
				String ename = rs.getString("ename");
				String e = rs.getString("email");
				String p = rs.getString("password");
				int did = rs.getInt("deptId");
				String dname = rs.getString("dname");
				String l = rs.getString("dlocation");

				employee = new FullDeatilsOfemployees(id, ename, e, p, did, dname, l);
			} else {

				throw new employeeException("Employee not found...");
			}
		} catch (SQLException e) {

			throw new employeeException(e.getMessage());
		}

		return employee;
	}

	@Override
	public String changePassword(String ename, int eid, String newPassword) throws employeeException {

		String message = "Employee not found";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("update employee set password = ? where ename = ? AND Eid = ?");

			ps.setString(1, newPassword);
			ps.setString(2, ename);
			ps.setInt(3, eid);

			int x = ps.executeUpdate();

			if (x > 0) {
				message = "Password updated successfuly";
			} else {
				throw new employeeException("Employee not found");
			}

		} catch (SQLException se) {

			throw new employeeException(se.getMessage());
		}

		return message;
	}

	@Override
	public String ApplyLeave(int eid, String name, int days) throws employeeException {
		String message = "Failed to apply leave";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps1 = conn.prepareStatement("select * from employee where eid = ? AND ename=?");
			ps1.setInt(1, eid);
			ps1.setString(2, name);

			ResultSet rs = ps1.executeQuery();

			if (rs.next()) {

				PreparedStatement ps = conn.prepareStatement("insert into leave_status values (?,?,?,'applied')");

				ps.setInt(1, eid);
				ps.setString(2, name);
				ps.setInt(3, days);

				int x = ps.executeUpdate();

				if (x > 0) {
					message = "Leave applied successfully..";
				}
			} else {
				throw new employeeException("Employee not found..");
			}
		} catch (SQLException e) {
			throw new employeeException(e.getMessage());
		}

		return message;
	}

	@Override
	public List<Leave> showEmployeeLeave() throws LeaveException {

		List<Leave> list = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from Leave_status");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("eid");
				String name = rs.getString("ename");
				int days = rs.getInt("numberOfDays");
				String leaveStatus = rs.getString("LeaveStatus");

				list.add(new Leave(id, name, days, leaveStatus));
			}

		} catch (SQLException e) {
			throw new LeaveException(e.getMessage());
		}

		if (list.size() == 0) {
			throw new LeaveException("Leave is not applied from anyone..");
		}

		return list;
	}

	@Override
	public Leave showYourLeave(int id, String name) throws employeeException, LeaveException {
		Leave leave;

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("Select * from employee where eid = ? AND ename =?");
			ps.setInt(1, id);
			ps.setString(2, name);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				PreparedStatement ps1 = conn.prepareStatement("Select * from leave_Status where ename = ? And eid=?");

				ps1.setString(1, name);
				ps1.setInt(2, id);

				ResultSet rs1 = ps1.executeQuery();

				if (rs1.next()) {

					int eid = rs1.getInt("eid");
					String ename = rs1.getString("ename");
					int days = rs1.getInt("numberOfDays");
					String leaveStatus = rs1.getString("LeaveStatus");

					leave = new Leave(eid, ename, days, leaveStatus);

				} else {

					throw new LeaveException("Leave not applied yet..");
				}

			} else {
				throw new employeeException("Employee not found..");
			}

		} catch (SQLException e) {

			throw new employeeException(e.getMessage());
		}

		return leave;
	}

	@Override
	public List<FullDeatilsOfemployees> showFullList() throws employeeException {
		List<FullDeatilsOfemployees> list = new ArrayList<>();

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement(
					"select e.eid,e.ename,e.email,e.password,e.deptid,d.dname,d.dlocation from employee e  Inner Join department d ON e.deptId=d.deptId");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("eid");
				String ename = rs.getString("ename");
				String email = rs.getString("email");
				String password = rs.getString("password");
				int deptId = rs.getInt("deptId");
				String dname = rs.getString("dname");
				String dlocation = rs.getString("dlocation");

				list.add(new FullDeatilsOfemployees(id, ename, email, password, deptId, dname, dlocation));

			}

		} catch (SQLException e) {

			throw new employeeException(e.getMessage());

		}

		if (list.size() == 0) {
			throw new employeeException("No employee Found...");
		}

		return list;
	}

	@Override
	public String changeEmail(String name, int id, String newEmail) throws employeeException {
		String message = "Employee not found";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update employee set email = ? where ename = ? AND Eid = ?");

			ps.setString(1, newEmail);
			ps.setString(2, name);
			ps.setInt(3, id);

			int x = ps.executeUpdate();

			if (x > 0) {
				message = "Email updated successfuly";
			} else {
				throw new employeeException("Employee not found");
			}

		} catch (SQLException se) {

			throw new employeeException(se.getMessage());
		}

		return message;
	}

	@Override
	public String changeName(String email, int id, String newName) throws employeeException {
		String message = "Employee not found";

		try (Connection conn = DBUtil.provideConnection()) {

			PreparedStatement ps = conn.prepareStatement("update employee set ename = ? where email = ? AND Eid = ?");

			ps.setString(1, newName);
			ps.setString(2, email);
			ps.setInt(3, id);

			int x = ps.executeUpdate();

			if (x > 0) {
				message = "Name updated successfuly";
			} else {
				throw new employeeException("Employee not found");
			}

		} catch (SQLException se) {

			throw new employeeException(se.getMessage());
		}

		return message;
	}

}
