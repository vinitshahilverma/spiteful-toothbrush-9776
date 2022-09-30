package com.useCase;

import java.util.Scanner;

import com.bean.Employee;
import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.employeeException;

public class EmployeeDetails {

	public static void employeeDetails() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your email");
		String email = sc.next();

		System.out.println("Enter your password");
		String password = sc.next();

		AdminDao dao = new AdminDaoImpl();

		try {
			Employee emp = dao.viewDetails(email, password);
			
			System.out.println("Employee name: "+emp.getName());
			System.out.println("Employee id: "+emp.getId());
			System.out.println("Employee email: "+emp.getEmail());
			System.out.println("Employee password: "+emp.getPassword());
			System.out.println("Employee  Departemnt Number: "+emp.getDepartment());
			

		} catch (employeeException e) {
			System.out.println(e.getMessage());
		}

	}

}
