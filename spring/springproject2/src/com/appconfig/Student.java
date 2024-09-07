package com.appconfig;

public class Student {
	String nameString;
	
	String cityString;

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getCityString() {
		return cityString;
	}

	public void setCityString(String cityString) {
		this.cityString = cityString;
	}

	public Student(String nameString, String cityString) {
		super();
		this.nameString = nameString;
		this.cityString = cityString;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [nameString=" + nameString + ", cityString=" + cityString + "]";
	}
	
	
}
