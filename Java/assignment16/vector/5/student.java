package practise;

import java.io.Serializable;

public class Student implements Serializable {
	int rollno;
	String nameString;
	public Student(int rollno, String nameString) {
		super();
		this.rollno = rollno;
		this.nameString = nameString;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", nameString=" + nameString + "]";
	}
	
	
}
