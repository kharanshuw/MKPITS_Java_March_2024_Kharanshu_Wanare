package practise;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Myhashset {
	public static void main(String[] args) {
		HashSet<Integer> hashSet = new HashSet<Integer>();

		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);

		HashSet<Integer> hashSet2 = new HashSet<Integer>();

		hashSet2.add(1);
		hashSet2.add(2);
		hashSet2.add(3);
		
		System.out.println(hashSet.equals(hashSet2));

	}
}
