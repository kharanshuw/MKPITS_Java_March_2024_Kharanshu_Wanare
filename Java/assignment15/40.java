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
	
	  LinkedList<Integer> linkedList2=new LinkedList<Integer>();
	  
	  Collections.copy(linkedList, linkedList2);
	  System.out.println(linkedList2);
	  
	  
}
}
