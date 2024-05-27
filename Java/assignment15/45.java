package practise;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Mylinkedlist {
	
	public boolean comparecontenet(LinkedList<Integer> linkedList,LinkedList<Integer> linkedList2) {
		if (linkedList.containsAll(linkedList2) && linkedList2.containsAll(linkedList)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> linkedList=new LinkedList<Integer>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		
		LinkedList<Integer> linkedList2=new LinkedList<Integer>();
		linkedList2.add(1);
		linkedList2.add(2);
		linkedList2.add(3);
		linkedList2.add(5);
		linkedList2.add(4);
		
		Mylinkedlist mylinkedlist=new Mylinkedlist();
		boolean result=mylinkedlist.comparecontenet(linkedList, linkedList2);
		System.out.println(result);
	}
}
