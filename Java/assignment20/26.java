package assignment20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Assignment20 {	
	public static void main(String[] args) {
		 List<Integer> list = new ArrayList<Integer>(); 
	        list.add(1); 
	        list.add(3); 
	        list.add(7);
	        list.add(4);
	        list.add(null);
	        list.add(null);
	        TestClass testClass=new TestClass();
	        
	     List<Integer> arrayList =  list.stream().filter(Objects::nonNull).collect(Collectors.toList());
	     System.out.println(arrayList);
	}
}
