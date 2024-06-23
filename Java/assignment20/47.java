package assignment20;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



public class Assignment20 {	
	public static void main(String[] args) {
		 ArrayList<String> arrayList=new ArrayList<String>();
		 arrayList.add("a");
		 arrayList.add("b");
		 arrayList.add("c");
		 arrayList.add("d");
		 
	Set<String> set	=arrayList.stream().map(
				x->{
				return	x.toUpperCase();
				}
				).collect(Collectors.toSet());
	System.out.println(set);
	}
}
