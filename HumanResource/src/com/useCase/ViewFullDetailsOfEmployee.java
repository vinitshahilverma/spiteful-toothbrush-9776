package com.useCase;

import java.util.List;

import com.bean.FullDeatilsOfemployees;
import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.employeeException;

public class ViewFullDetailsOfEmployee {

	public static void viewFullList() {

		AdminDao dao = new AdminDaoImpl();

		try {
			List<FullDeatilsOfemployees> list = dao.showFullList();

			list.forEach(f -> {
                
				System.out.println("============================================");
				
				System.out.println("Employee id: " + f.getEid());
				System.out.println("Employee name: " + f.getEname());
				System.out.println("Employee email: " + f.getEmail());
				System.out.println("Employee password: " + f.getPassword());
				System.out.println("Department id: " + f.getDeptId());
				System.out.println("Department name: " + f.getDname());
				System.out.println("Department location: " + f.getDlocation());

				System.out.println("============================================");

			});

		} catch (employeeException e) {
			System.out.println(e.getMessage());
		}

	}

}
