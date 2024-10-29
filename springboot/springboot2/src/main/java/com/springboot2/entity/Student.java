package com.springboot2.entity;

public class Student {

	String rollnoString;

	String nameString;

	public String getRollnoString() {
		return rollnoString;
	}

	public void setRollnoString(String rollnoString) {
		this.rollnoString = rollnoString;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public Student(String rollnoString, String nameString) {
		super();
		this.rollnoString = rollnoString;
		this.nameString = nameString;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
