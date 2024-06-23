package assignment20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class Assignment20 {	
	public static void main(String[] args) {
		 List<Integer> list=new ArrayList<Integer>();  
		 list.add(5);
		 list.add(10);
		 list.add(15);
		 list.add(20);
		 
		Double double1= list.stream().mapToDouble(
				 x->{
					 return x*x;
				 }
				 ).sum();
		
		System.out.println(double1);
	}
}
