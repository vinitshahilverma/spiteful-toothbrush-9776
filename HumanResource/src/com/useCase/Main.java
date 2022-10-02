package com.useCase;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

//		Admin

//      AdminLogin.admin();
//	    ViewDepartments.department();
//	    AddingDepartment.addDepartment();
//	    AddEmployee.addEmployee();
//	    updateEmpDept.updateDept();
//		ActionOnLeave.actionLeave();
//		ViewLeaveList.viewList();
//		ViewFullDetailsOfEmployee.viewFullList();

//      Employee

//      EmployeeLogin.employee();
//	    EmployeeDetails.employeeDetails();
//      ChangeEmpPassword.changePassword();
//		ApplyLeave.applyLeave();
//		ViewPersonalLeave.leave();
//		ChangeEmpName.changeName();
//		ChangeEmpEmail.changeEmail();

		while (true) {
			System.out.println("======================================================");
			System.out.println("Welcome to the Human Resource Management System....");
			System.out.println("======================================================");
			System.out.println("Enter 1 to Login as Admin");
			System.out.println("Enter 2 to Login as Employee");

			Scanner sc = new Scanner(System.in);
			try {
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				String str = AdminLogin.admin();
				if (str.equals("Wrong Credentials")) {
					System.out.println("Wrong Credentials");
					break;
				} else {

					System.out.println("Login Successfully..");

					while (true) {
						System.out.println("============================================");
						System.out.println("Enter 1 to View all available Departments");
						System.out.println("Enter 2 to View all Employee Details");
						System.out.println("Enter 3 to Add new Department");
						System.out.println("Enter 4 to Add new Employee");
						System.out.println("Enter 5 to Change an Employee Department");
						System.out.println("Enter 6 to see all the applied Leaves");
						System.out.println("Enter 7 to take action on the applied leaves");
						System.out.println("Enter 8 to Exit...");

						int choice2 = sc.nextInt();

						switch (choice2) {

						case 1:
							ViewDepartments.department();
							break;

						case 2:
							ViewFullDetailsOfEmployee.viewFullList();
							break;

						case 3:
							AddingDepartment.addDepartment();
							break;

						case 4:
							AddEmployee.addEmployee();
							break;

						case 5:
							updateEmpDept.updateDept();
							break;

						case 6:
							ViewLeaveList.viewList();
							break;

						case 7:
							ActionOnLeave.actionLeave();
							break;

						case 8:
							System.out.println("Thank you....");
							;

						}

						if (choice2 == 8) {
							break;
						}

					}

					break;
				}
			case 2:
				String str1 = EmployeeLogin.employee();
				if (str1.equals("Wrong Credentials")) {
					System.out.println("Wrong Credentials");
					break;
				} else {
					System.out.println("Login Succesfully....");

					while (true) {
						System.out.println("============================================");
						System.out.println("Enter 1 to View Your Details");
						System.out.println("Enter 2 to Update your Password");
						System.out.println("Enter 3 to Update your Name");
						System.out.println("Enter 4 to Update your Email");
						System.out.println("Enter 5 to Apply Leave");
						System.out.println("Enter 6 to View your Leave Status");
						System.out.println("Enter 7 to Exit....");

						int choice3 = sc.nextInt();

						switch (choice3) {

						case 1:
							EmployeeDetails.employeeDetails();
							break;

						case 2:
							ChangeEmpPassword.changePassword();
							break;

						case 3:
							ChangeEmpName.changeName();
							break;

						case 4:
							ChangeEmpEmail.changeEmail();
							break;

						case 5:
							ApplyLeave.applyLeave();
							break;

						case 6:
							ViewPersonalLeave.leave();
							break;

						case 7:
							System.out.println("Thank You...");
							break;
						}

						if (choice3 == 7) {
							break;
						}

					}
				}

			}
			}catch(InputMismatchException e) {
				System.out.println("Please enter valid Input..");
			}
		}

	}

}
