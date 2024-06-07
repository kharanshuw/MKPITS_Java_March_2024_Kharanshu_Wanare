package assignment20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Assignment20 {	
	public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
      //  (String::valueOf): This part defines the function that will be applied to each element. It uses a method reference syntax:
      //  	String::: This refers to the String class.
     //   	valueOf: This refers to the static method valueOf within the String class. The valueOf method takes an object as input and returns its string representation.    
		
       List<String> list  =numbers.stream().map(
    		   
    		   String::valueOf
    		   
//    		   (x)->{
//    			return x.toString();   
//    		   }
    		   
    		   ).collect(Collectors.toList());
		System.out.println(list);
	}
}
