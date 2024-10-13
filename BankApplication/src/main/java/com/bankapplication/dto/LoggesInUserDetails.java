package com.bankapplication.dto;

import java.util.ArrayList;

public class LoggesInUserDetails {

	private int id;
	private String email;
	private String fname;
	private String lname;
	private String gender;
	private String phoneno;
	private ArrayList<String> roleNames = new ArrayList<>();

	public LoggesInUserDetails(int id, String email, String fname, String lname, String gender, String phoneno,
			ArrayList<String> roleNames) {
		super();
		this.id = id;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.phoneno = phoneno;
		this.roleNames = roleNames;
	}

	@Override
	public String toString() {
		return "LoggesInUserDetails [id=" + id + ", email=" + email + ", fname=" + fname + ", lname=" + lname
				+ ", gender=" + gender + ", phoneno=" + phoneno + ", roleNames=" + roleNames + "]";
	}

	public LoggesInUserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public ArrayList<String> getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(ArrayList<String> roleNames) {
		this.roleNames = roleNames;
	}

	public void addRole(String roleName) {
		this.roleNames.add(roleName);
	}

}