package practise;

import java.util.Iterator;
import java.util.LinkedList;

public class Mylinkedlist {
	public static void main(String[] args) {
		LinkedList<Integer> linkedList=new LinkedList();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		
	Iterator<Integer> iterator	 =linkedList.descendingIterator();
	
	while (iterator.hasNext()) {
		Integer integer = (Integer) iterator.next();
		System.out.println(integer);
	}
	}
}
