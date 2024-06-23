package assignment20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class Assignment20 {	
	public static void main(String[] args) {
		 List<String> list=new ArrayList<String>();  
		   
		 list.add("M");  
		 list.add("Apple");  
		 list.add("Banana");  
		 list.add("Grapes");  
		 
		 
	Comparator<String> c	= Comparator.comparing(String::length);
		 
		Optional<String> strOptional=list.stream().min(c);
		
		if (strOptional.isPresent()) {
			System.out.println("min stream  "+strOptional.get());
		}
		else {
			
			System.out.println("not present");
		}
	}
}
