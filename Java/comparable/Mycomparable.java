package myproject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Mycomparable {


public static void main(String[] args) {
	List<Student> list=new ArrayList<Student>();
	list.add(new Student("pratik",25));
	list.add(new Student("shreyash",23));
	list.add(new Student("utkarsh",29));
	Collections.sort(list);
}
}
