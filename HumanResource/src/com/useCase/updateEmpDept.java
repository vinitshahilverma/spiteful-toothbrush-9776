package com.useCase;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.DepartmentException;
import com.exception.employeeException;

public class updateEmpDept {

	public static void updateDept() {

		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("Enter Employee id");
			int id = sc.nextInt();

			System.out.println("Enter Employee name");
			String name = sc.next();

			System.out.println("Enter new Department Id");
			int deptid = sc.nextInt();

			AdminDao dao = new AdminDaoImpl();

			String str = dao.updateEmployeeDepartment(id, name, deptid);
			System.out.println("============================================");
			System.out.println(str);
			System.out.println("============================================");
		} catch (employeeException | DepartmentException e) {
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
