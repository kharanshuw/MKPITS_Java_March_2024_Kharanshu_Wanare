package comparator;

import java.util.Collections;
import java.util.LinkedList;

public class Main {
public static void main(String[] args) {
	LinkedList<Student> linkedList=new LinkedList<Student>();
	linkedList.add(new Student("a",3));
	linkedList.add(new Student("b",2));
	linkedList.add(new Student("c",1));
	
	System.out.println(linkedList);
	
	Collections.sort(linkedList,new NameComparator());
	
	System.out.println(linkedList);
	
	Collections.sort(linkedList,new AgeComparator());
	System.out.println(linkedList);
}
}
