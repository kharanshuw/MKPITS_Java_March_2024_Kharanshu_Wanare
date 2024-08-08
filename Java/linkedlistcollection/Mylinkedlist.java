package myproject;

import java.util.Iterator;
import java.util.LinkedList;

public class Mylinkedlist {
public static void main(String[] args) {
	LinkedList<Integer> linkedList = new LinkedList<Integer>();
	linkedList.add(45);
	linkedList.add(78);
	linkedList.add(99);
	linkedList.add(741);
	/*System.out.println(linkedList);
	//linkedList.clear();
	System.out.println(linkedList.getFirst());
	System.out.println(linkedList.get(1));
	System.out.println(linkedList.indexOf(99));
	System.out.println(linkedList.offer(4));
	System.out.println(linkedList);
	System.out.println(linkedList.peek());*/
	Iterator iterator=linkedList.iterator();
	while (iterator.hasNext()) {
		Integer object = (Integer) iterator.next();
		System.out.println(object);
	}
	
	LinkedList<Student> students=new LinkedList<Student>();
	students.add(new Student("aa"));
	students.add(new Student("bb"));
	students.add(new Student("c"));
	students.add(new Student("dd"));
	/*System.out.println("studen objects"+students);
	for (Student student : students) {
		System.out.println("student"+student);
	}*/
	iterator=students.iterator();
	while (iterator.hasNext()) {
		Student student1 = (Student) iterator.next();
		System.out.println(student1);
	}
}
}
