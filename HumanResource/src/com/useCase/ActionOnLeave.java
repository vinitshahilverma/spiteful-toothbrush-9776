package com.useCase;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.employeeException;

public class ActionOnLeave {

	public static void actionLeave() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Employee id ");
		int id = sc.nextInt();

		System.out.println("Enter the Status you want to Update...");
		String status = sc.next();

		AdminDao dao = new AdminDaoImpl();

		try {
			String str = dao.updateLeaveStatus(id, status);
			System.out.println("============================================");
			System.out.println(str);
			System.out.println("============================================");
		} catch (employeeException e) {
			System.out.println("============================================");
			System.out.println(e.getMessage());
			System.out.println("============================================");
		} catch (InputMismatchException e) {
			System.out.println("============================================");
			System.out.println("Please Enter valid Input....");
			System.out.println("============================================");
		}

	}

}
