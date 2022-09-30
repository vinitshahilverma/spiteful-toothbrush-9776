package com.useCase;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.employeeException;


public class EmployeeLogin {
	
	public static void employee() {
		
       Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter you email..");
		String email = sc.next();
		
		System.out.println("Enter your password");
		String password = sc.next();
		
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			String str = dao.LoginEmployee(email, password);
			
			System.out.println(str);
		}
		 catch(employeeException am) {
			 
			 System.out.println(am.getMessage());
		 }

	}
	}


