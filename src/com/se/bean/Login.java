package com.se.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.se.controller.LoginController;
import com.se.controller.RegistrationController;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

/**
	 * 
	 */
private static final long serialVersionUID = -7369491420258013611L;


private String loginId;
private String password;
private String msg;


public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}

/**
 * @return the loginId
 */
public String getLoginId() {
	return loginId;
}

/**
 * @param loginId the loginId to set
 */
public void setLoginId(String loginId) {
	this.loginId = loginId;
}



/**
* @return the password
*/
public String getPassword() {
return password;
}

/**
* @param password the password to set
*/
public void setPassword(String password) {
this.password = password;
}

public Login() {
	// TODO Auto-generated constructor stub
}

public Login(String loginId, String password) {
	super();
	this.loginId = loginId;
	this.password = password;
}

public String login() {

	Login user = new Login(loginId, password);
	
	boolean isValid = LoginController.validateLogin(user);
	if (isValid == true) {
		return "success";
	} else  {
		System.out.println("inside this");
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Incorrect Username and Passowrd",
						"Please enter correct username and Password"));
		return "index";
	}
	
}



public void logout() throws IOException {
	
	ExternalContext externalContext =  FacesContext.getCurrentInstance().getExternalContext();
	externalContext.invalidateSession();
	externalContext.redirect("index.xhtml");
	
}
}