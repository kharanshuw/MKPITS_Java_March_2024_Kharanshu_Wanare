package myproject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=Arrays.asList(5,10,10,20,20,30,30,40,50);
		
		Set<Integer> set=new HashSet<Integer>();
		
		for (Integer xInteger : list) {
			set.add(xInteger);
		}
		
		System.out.println(set);
	}

}
