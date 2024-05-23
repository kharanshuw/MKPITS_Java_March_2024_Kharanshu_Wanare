package assignment14.assignment15;

import java.util.HashSet;
import java.util.Iterator;

public class Enrollment {
	HashSet<Course> hashSet = new HashSet<Course>();

	public void add(Course course) {
		hashSet.add(course);
	}
	
	public void display() {
		Iterator<Course> iterator=hashSet.iterator();
		while (iterator.hasNext()) {
			Course course = (Course) iterator.next();
			System.out.println(course);
		}
	}
	
	public void check(long coursecode) {
		Iterator<Course> iterator=hashSet.iterator();
		boolean flag=false;
		while (iterator.hasNext()) {
			Course c = (Course) iterator.next();
			if (c.getCoursecode()==coursecode) {
				System.out.println("couse alredy present");
				flag=true;
			}
		}
		if (flag==false) {
			System.out.println("course not present");
		}
		
	}
	
	public void remove(long coursecode) {
		Iterator<Course> iterator=hashSet.iterator();
		boolean flag=false;
		while (iterator.hasNext()) {
			Course c = (Course) iterator.next();
			if (c.getCoursecode()==coursecode) {
				iterator.remove();
			}
		}
		
		
	}
}
