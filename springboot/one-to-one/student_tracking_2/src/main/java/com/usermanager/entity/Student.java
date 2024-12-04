package com.usermanager.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastnameString;
	@OneToOne(cascade = CascadeType.ALL)
	private Student_details student_details;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastnameString() {
		return lastnameString;
	}

	public void setLastnameString(String lastnameString) {
		this.lastnameString = lastnameString;
	}

	public Student_details getStudent_details() {
		return student_details;
	}

	public void setStudent_details(Student_details student_details) {
		this.student_details = student_details;
	}

}
