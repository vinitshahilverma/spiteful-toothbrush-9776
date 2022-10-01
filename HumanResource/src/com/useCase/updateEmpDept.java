package com.useCase;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.DepartmentException;
import com.exception.employeeException;

public class updateEmpDept {
	
	
	public static void updateDept() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee id");
		int id = sc.nextInt();
		
		System.out.println("Enter Employee name");
		String name = sc.next();
		
		System.out.println("Enter new Department Id");
		int deptid = sc.nextInt();
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			String str = dao.updateEmployeeDepartment(id, name, deptid);
			
			System.out.println(str);
			
		} catch (employeeException | DepartmentException e) {
			
			System.out.println(e.getMessage());
		}
		
		
	}

}
