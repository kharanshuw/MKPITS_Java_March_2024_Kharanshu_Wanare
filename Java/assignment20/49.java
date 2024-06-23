package assignment20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class Assignment20 {	
	public static void main(String[] args) {
		 List<String> list=new ArrayList<String>();  
		   
		 list.add("M");  
		 list.add("Apple");  
		 list.add("Banana");  
		 list.add("Grapes");  
		 
		 
	Map<String, String> map	= list.stream().collect(Collectors.toMap(
				 x->{
					 return x;
				 }
				 ,x->{ 
				return	 new StringBuilder(x).reverse().toString();
				 }
				 
				 ));
	System.out.println(map);
	}
}
