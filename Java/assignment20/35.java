package assignment20;

import java.util.ArrayList;

import java.util.List;


public class Assignment20 {	
	public static void main(String[] args) {
		 List<String> list=new ArrayList<String>();  
		   
		 list.add("M");  
		 list.add("Apple");  
		 list.add("Banana");  
		 list.add("Grapes");  
		 list.stream().flatMapToInt(String::chars).mapToObj(n->(char) n).distinct().forEach(n-> System.out.print(n+" "));
	}
}
