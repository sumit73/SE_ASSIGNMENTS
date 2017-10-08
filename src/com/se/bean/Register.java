package com.se.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import com.se.controller.*;

@ManagedBean
public class Register implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -1149252938824280071L;
	public String firstName;
	public String lastName;
	public String address;
	public String phoneNumber;
	public String emailAddress;
	public String userName;
	public String password;
	
	
	
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	
	
	public Register() {
		// TODO Auto-generated constructor stub
	}

	public Register(String firstName, String lastName, String address, String phoneNumber, String emailAddress,
			String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.userName = userName;
		this.password = password;
	}
	
	
	public String register(){
		
		
		Register user = new Register(firstName, lastName, address, phoneNumber, emailAddress, userName, password);
		
		boolean isRegistered = RegistrationController.newUSerRegistration(user);
		if(isRegistered == true)
			return "registered";
		else
			return "error";
	}
	
	
	@Override
	public String toString() {
		return "Register [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", emailAddress=" + emailAddress + ", userName=" + userName + ", password=" + password
				+ "]";
	}
	
	
	
	
}
