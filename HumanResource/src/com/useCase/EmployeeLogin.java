package com.useCase;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.employeeException;

public class EmployeeLogin {

	public static String employee() {

		String str = "Something went Worng..";

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter you email..");
		String email = sc.next();

		System.out.println("Enter your password");
		String password = sc.next();

		AdminDao dao = new AdminDaoImpl();

		try {
			str = dao.LoginEmployee(email, password);

		} catch (employeeException am) {

			str = am.getMessage();
		}

		return str;

	}
}
