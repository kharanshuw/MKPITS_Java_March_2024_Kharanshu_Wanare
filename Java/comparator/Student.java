package comparator;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable{

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

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	
	/*public int compareTo(Student o) {
		Integer nextageInteger=o.getAge();
		Integer myageInteger=this.getAge();
//		if (age==nextageInteger) {
//			return 0;
//		}
//		else if (age>nextageInteger) {
//			return 1;
//		}
//		else {
//			return -1;
//		}
		return myageInteger.compareTo(nextageInteger);
		
	}*/



	

	

}
