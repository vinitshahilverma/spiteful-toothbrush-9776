package com.useCase;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.AdminException;

public class AdminLogin {

	public static void main(String[] args) {
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			String str = dao.LoginAdmin("shahil@gmail.com", "12345");
			
			System.out.println(str);
		}
		 catch(AdminException am) {
			 
			 System.out.println(am.getMessage());
		 }

	}

}
