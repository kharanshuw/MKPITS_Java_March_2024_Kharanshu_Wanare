package myproject;

import java.util.Scanner;

public class Student implements Comparable {

	private String name;
	private int age;
	
	

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Student() {

	}

	public Student(String name) {
		this.name = name;

	}

	public void setName(String newName) {
		name = newName;
	}

	public void setAge(int newAge) {
		age = newAge;
	}

	

	

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	
	public String toString() {
		return "Name: " + name + ", Age: " + age + ", Address: " +  + ", Email: " + email;
	}

	@Override
	public int compareTo(Object o) {
		return name.compareTo(((Student)o).name);
	}

}
