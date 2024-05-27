package practise;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Myhashset {	
	public static void main(String[] args) {
		TreeSet<Integer> treeSet=new TreeSet<Integer>();
		
		treeSet.add(1);
		treeSet.add(0);
		treeSet.add(2);
		treeSet.add(3);
		treeSet.add(4);
		treeSet.add(7);
		
		System.out.println(treeSet);
		
		Iterator<Integer> iterator=treeSet.iterator();
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			if (integer<7) {
				System.out.println(integer);
			}
		}
		
	}
}
