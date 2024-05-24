
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Mylinkedlist {
public static void main(String[] args) {
	  LinkedList<Integer> linkedList=new LinkedList<Integer>();
	  
	  linkedList.add(78);
	  linkedList.add(1);
	  linkedList.add(2);
	  linkedList.add(3);
	  linkedList.add(linkedList.size(),45);
	  
	  Iterator<Integer> linIterator=linkedList.iterator();
	  while (linIterator.hasNext()) {
		Integer integer = (Integer) linIterator.next();
		System.out.println(integer);
	}
}
}
