package com.bankapplication.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RequestDto {

	@Column(name = "password", nullable = false)
	@Size(min = 8, max = 128, message = "password length must be between 0 to 128")
	@NotEmpty(message = "password should not be empty")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,128}$", message = "Password must meet requirements (8-128 chars, uppercase, lowercase, digit, special char)")
	private String password;

	@Column(name = "email")
	@NotEmpty(message = "email should not be empty")
	@NotNull(message = "email should not be empty")
	private String email;

	@Column(name = "fname")
	@NotEmpty(message = "First name cannot be empty")
	@Size(min = 2, max = 50, message = "First name must be between 2 to 50 characters")
	private String fname;

	@Column(name = "lname")
	@NotEmpty(message = "Last name cannot be empty")
	@Size(min = 2, max = 50, message = "Last name must be between 2 to 50 characters")
	private String lname;

	@Column(name = "phoneno")
	@NotEmpty(message = "Phone number cannot be empty")
	@Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
	private String phoneno;

	@Column(name = "gender")
	@NotEmpty(message = "gender should not be empty")
	private String gender;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "RequestDto{" + "password='" + password + '\'' + ", email='" + email + '\'' + ", fname='" + fname + '\''
				+ ", lname='" + lname + '\'' + ", phoneno='" + phoneno + '\'' + ", gender='" + gender + '\'' + '}';
	}
}
