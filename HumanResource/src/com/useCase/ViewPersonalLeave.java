package com.useCase;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.bean.Leave;
import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.LeaveException;
import com.exception.employeeException;

public class ViewPersonalLeave {

	public static void leave() {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter your Employee id");
			int id = sc.nextInt();

			System.out.println("Enter your Name");
			String name = sc.next();

			AdminDao dao = new AdminDaoImpl();

			Leave leave = dao.showYourLeave(id, name);

			System.out.println("Employee id: " + leave.getId());
			System.out.println("Employee name: " + leave.getEname());
			System.out.println("Leave applied for: " + leave.getDays() + " Days");
			System.out.println("Leave Status: " + leave.getStatus());

		} catch (employeeException | LeaveException e) {

			System.out.println(e.getMessage());

		} catch (InputMismatchException e) {

			System.out.println("Please Enter right Input....");

		}

	}

}
