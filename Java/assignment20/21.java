package assignment20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Assignment20 {	
	public static void main(String[] args) {
		 List<String> myList = new ArrayList<>();
	        myList.add("apple");
	        myList.add("banana");
	        myList.add("cherry");
	        TestClass testClass=new TestClass();
	   Map<String, Integer> map = myList.stream()
	     .collect(
	    		 /*
	    		  * .collect(Collectors.toMap(str -> str, str -> str.length())): This operation uses the Collectors.
	    		  * toMap collector to create a map. 
	    		  * It takes two arguments:
					str -> str: This is a function (lambda expression) that defines the key for each element. Here, it simply uses the string itself (str) as the key.
					str -> str.length(): This function defines the value for each element. It uses str.length() to get the length of the string and assigns it as the value.
	    		  */
	    		 Collectors.toMap(testClass::stringx,testClass::stringlength)
	    		 );
	     
	     System.out.println(map);
       
	}
}
