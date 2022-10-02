package com.useCase;

import java.util.List;

import com.bean.Department;
import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.DepartmentException;

public class ViewDepartments {

	public static void department() {

		AdminDao dao = new AdminDaoImpl();

		try {
			List<Department> list = dao.showDepartment();

			list.forEach(d -> {
				
				System.out.println("============================================");
				
				System.out.println("Department id: " + d.getId());
				System.out.println("Department name: " + d.getDname());
				System.out.println("Department location: " + d.getLocation());

				System.out.println("========================================");

			});

		} catch (DepartmentException e) {
			System.out.println(e.getMessage());
		}

	}

}
