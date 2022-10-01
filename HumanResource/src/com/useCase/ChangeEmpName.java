package com.useCase;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.employeeException;

public class ChangeEmpName {
	
	
	public static void changeName() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your email");
		String email = sc.next();
		
		System.out.println("Enter your id");
		int id = sc.nextInt();
		
		System.out.println("Enter your new name");
		String name = sc.next();
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			String str = dao.changeName(email, id, name);
			
			System.out.println(str);
		} catch (employeeException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
