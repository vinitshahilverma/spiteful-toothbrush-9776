package com.useCase;

import java.util.List;

import com.bean.Leave;
import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.LeaveException;

public class ViewLeaveList {

	public static void viewList() {

		AdminDao dao = new AdminDaoImpl();

		try {
			List<Leave> list = dao.showEmployeeLeave();

			list.forEach(l -> {
				System.out.println("============================================");
				
				System.out.println("Employee id: " + l.getId());
				System.out.println("Employee name: " + l.getEname());
				System.out.println("Leave applied for: " + l.getDays() + " Days");
				System.out.println("Leave Status: " + l.getStatus());

				System.out.println("=====================================");

			});

		} catch (LeaveException e) {
			System.out.println(e.getMessage());

		}

	}

}
