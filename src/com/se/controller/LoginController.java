package com.se.controller;

import com.se.bean.Login;
import com.se.bean.Register;
import com.se.dao.LoginDao;
import com.se.dao.RegistrationDao;

public class LoginController {

	public static boolean validateLogin(Login user) {
		
		boolean isValid = LoginDao.validateLgin(user);
		
		
		return isValid;
	}
	
}
