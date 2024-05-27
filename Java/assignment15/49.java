package practise;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Myhashset {	
	public static void main(String[] args) {
		HashSet<Integer> h=new HashSet<Integer>();
		h.add(2);
		h.add(3);
		h.add(4);
		
		Iterator<Integer> iterator=h.iterator();
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
		}
	}
}
