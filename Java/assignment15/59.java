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

		hashSet.clear();
		
		System.out.println(hashSet);
	}
}
