package com.MVC_1.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {

	@NotEmpty(message = "is required")
	@Size(min = 4, message = "first name must be min 4 charecter")
	private String firstnameString;

	@NotEmpty(message = "is required")
	@Size(min = 6, message = "length of lastname must be min 6")
	private String lastnameString;

	@NotEmpty(message = "is required")
	@Email
	private String emailString;

	@NotEmpty(message = "is required")
	@Size(min = 3, max = 15, message = "password size must be min 3 max 15")
	private String passwordString;

	@NotNull(message = "is required")
	@Min(value = 18, message = "min age should be 18")
	private int age;

	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}

	public String getPasswordString() {
		return passwordString;
	}

	public void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstnameString() {
		return firstnameString;
	}

	public void setFirstnameString(String firstnameString) {
		this.firstnameString = firstnameString;
	}

	public String getLastnameString() {
		return lastnameString;
	}

	public void setLastnameString(String lastnameString) {
		this.lastnameString = lastnameString;
	}

}
