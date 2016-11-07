/**
 * 
 */
package com.mindtree.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author M1035998
 *
 */
public class LoginDetails {
	
	
	private String email;
	

private	String password;
	
	
	
/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
/**
	 * @param email
	 * @param password
	 */
	public LoginDetails(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
/**
	 * 
	 */
	public LoginDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


}
