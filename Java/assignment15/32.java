
import java.util.LinkedList;

import java.util.ListIterator;

public class Mylinkedlist {
public static void main(String[] args) {
	  LinkedList<Integer> linkedList=new LinkedList<Integer>();
	  
	  linkedList.add(78);
	  linkedList.add(1);
	  linkedList.add(1);
	  linkedList.add(2);
	  linkedList.add(1);
	  linkedList.add(3);
	  linkedList.add(1);
	  linkedList.add(1);	  
	  linkedList.add(linkedList.size(),45);
	
	  int lastindex=-1;
	  for (int i = 0; i < linkedList.size(); i++) {
		if (linkedList.get(i)==1) {
			System.out.println(" first index"+i);
			break;
		}
	  }	 
	  for (int i = 0; i < linkedList.size(); i++) {
			if (linkedList.get(i)==1) {
				lastindex=i+1;
			}
		  }	
	  System.out.println("lastindex "+lastindex);
}
}
