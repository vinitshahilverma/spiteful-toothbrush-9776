package com.useCase;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.AdminException;

public class AdminLogin {

	public static void admin() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter you email..");
		String email = sc.next();
		
		System.out.println("Enter your password");
		String password = sc.next();
		
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			String str = dao.LoginAdmin(email, password);
			
			System.out.println(str);
		}
		 catch(AdminException am) {
			 
			 System.out.println(am.getMessage());
		 }

	}

}
