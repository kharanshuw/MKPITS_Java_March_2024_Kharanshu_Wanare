package assignment14.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StudentManagementSystem {
	ArrayList<Student> arrayList =new ArrayList<Student>();
	
	public void addstudent(int id,String name,String grades) {
		Student student=new Student(id,name,grades) ;
		arrayList.add(student);
		System.out.println("student is added in list");
	}
	
	public void removeById(int id) {
		Iterator<Student> iterator =arrayList.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			if (student.getId()==id) {
				iterator.remove();
				System.out.println("student detail deleted");
			}
		}
	}
	public void searchById(int id) {
		Iterator<Student> iterator =arrayList.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			if (student.getId()==id) {
				System.out.println("student detail "+student.toString());
			}
		}
	}
	
	public void display() {
		Iterator<Student> iterator =arrayList.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			System.out.println("student detail "+student.toString());
			
		}
	}
	
	public void sortcollection() {
		Collections.sort(arrayList);
	}
	
}
