package com.useCase;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.employeeException;

public class ApplyLeave {
	
	public static void applyLeave() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee id");
		int id = sc.nextInt();
		
		System.out.println("Enter employee name");
		String name = sc.next();
		
		System.out.println("Enter number of days you want to take leave ");
		int days = sc.nextInt();
		
		AdminDao  dao = new AdminDaoImpl();
		
		try {
			String str = dao.ApplyLeave(id, name, days);
			System.out.println(str);
			
		} catch (employeeException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		
	}

}
