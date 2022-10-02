package com.useCase;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.employeeException;

public class ChangeEmpPassword {

	public static void changePassword() {

		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("Enter employee id");
			int id = sc.nextInt();

			System.out.println("Enter employee name");
			String name = sc.next();

			System.out.println("Enter the password you want to change..");
			String password = sc.next();

			AdminDao dao = new AdminDaoImpl();

			String str = dao.changePassword(name, id, password);

			System.out.println(str);

		} catch (employeeException e) {

			System.out.println(e.getMessage());

		} catch (InputMismatchException e) {

			System.out.println("Please Enter right Input....");

		}

	}

}
