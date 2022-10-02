package com.useCase;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.bean.Department;
import com.dao.AdminDao;
import com.dao.AdminDaoImpl;

public class AddingDepartment {

	public static void addDepartment() {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter department id");
			int deptId = sc.nextInt();

			System.out.println("Enter department name");
			String name = sc.next();

			System.out.println("Enter department location");
			String location = sc.next();

			AdminDao dao = new AdminDaoImpl();

			Department dept = new Department(deptId, name, location);

			String str = dao.addDepartment(dept);
			
			System.out.println("============================================");
			System.out.println(str);
			System.out.println("============================================");

		} catch (InputMismatchException e) {
			System.out.println("============================================");
			System.out.println("Please Enter valid Input....");
			System.out.println("============================================");
		}

	}

}
