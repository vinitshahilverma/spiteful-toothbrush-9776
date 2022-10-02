package com.useCase;

import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.AdminException;

public class AdminLogin {

	public static String admin() {

		String str = "Something went wrong...";

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter you email..");
		String email = sc.next();

		System.out.println("Enter your password");
		String password = sc.next();

		AdminDao dao = new AdminDaoImpl();

		try {
			str = dao.LoginAdmin(email, password);

		} catch (AdminException am) {

			str = am.getMessage();
		}

		return str;
	}

}
