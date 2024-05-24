package assignment15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Mylinkedlist {
public static void main(String[] args) {
	  LinkedList<Integer> linkedList=new LinkedList<Integer>();
	  
	  linkedList.add(78);
	  linkedList.add(1);
	  linkedList.add(2);
	  linkedList.add(3);
	  linkedList.add(4, linkedList.size());
	  System.out.println(linkedList);
		
}
}
