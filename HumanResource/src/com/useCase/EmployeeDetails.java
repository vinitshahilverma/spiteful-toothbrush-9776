package com.useCase;

import java.util.Scanner;

import com.bean.Employee;
import com.bean.FullDeatilsOfemployees;
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
			FullDeatilsOfemployees emp = dao.viewDetails(email, password);
			System.out.println("============================================");
			System.out.println("Name: " + emp.getEname());
			System.out.println("Employee Id: " + emp.getEid());
			System.out.println("Email: " + emp.getEmail());
			System.out.println("Password: " + emp.getPassword());
			System.out.println("Department Id: " + emp.getDeptId());
			System.out.println("Department Name: " + emp.getDname());
			System.out.println("Department Location " + emp.getDlocation());
			System.out.println("============================================");
		} catch (employeeException e) {
			System.out.println("============================================");
			System.out.println(e.getMessage());
			System.out.println("============================================");
		}

	}

}
