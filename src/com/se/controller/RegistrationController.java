package com.se.controller;

import com.se.bean.Register;
import com.se.dao.RegistrationDao;

public class RegistrationController {

	public static boolean newUSerRegistration(Register user) {
		
		boolean isRegistered = RegistrationDao.registerNewUser(user);
		
		
		return isRegistered;
	}
	
	public static boolean isUserNameAvailable(String userName) {
		
		boolean isUserNameAvailable = RegistrationDao.isUserAlreadyExist(userName);
		
		return isUserNameAvailable;
	}
	
}
