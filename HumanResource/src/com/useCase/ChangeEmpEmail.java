package com.useCase;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.employeeException;

public class ChangeEmpEmail {

	public static void changeEmail() {

		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("Enter your name");
			String name = sc.next();

			System.out.println("Enter your id");
			int id = sc.nextInt();

			System.out.println("Enter your new email");
			String email = sc.next();

			AdminDao dao = new AdminDaoImpl();

			String str = dao.changeEmail(name, id, email);
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
