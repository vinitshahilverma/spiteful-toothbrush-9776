package com.useCase;

import java.util.Scanner;

import com.bean.Employee;
import com.dao.AdminDao;
import com.dao.AdminDaoImpl;

public class AddEmployee {
	
	public static void addEmployee() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee name");
		String name = sc.next();
		
		System.out.println("Enter employee email");
		String email = sc.next();
		
		System.out.println("Enter employee password");
		String password = sc.next();
		
		System.out.println("Enter employee deparmentId");
		int deptId = sc.nextInt();
		
		AdminDao dao = new AdminDaoImpl();
		
		Employee employee = new Employee();
		
		employee.setName(name);
		employee.setEmail(email);
		employee.setDepartment(deptId);
		employee.setPassword(password);
		
		String str = dao.registerEmployee(employee);
		
		System.out.println(str);
		
	}

}
