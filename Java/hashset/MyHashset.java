package myproject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyHashset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> set=new HashSet<Integer>();
		set.add(75);
		set.add(76);
		set.add(77);
		set.add(78);
		set.add(79);
		set.add(75);
		System.out.println("set1"+set);
		System.out.println(set.size());
		HashSet<Integer> set2=new HashSet<Integer>();
		set2=(HashSet<Integer>) set.clone();
		System.out.println("set2"+set2);
		
		Iterator<Integer> iterator=set.iterator();
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
		}
		
		Object[] objects=set2.toArray();
		System.out.println(objects);
		for (Object object : objects) {
			System.out.println(object);
		}
		
	}

}
