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
	        
	     List<String> list = myList.stream().filter(testClass::startswithstring).limit(1).collect(Collectors.toList());
	     System.out.println(list);
       
	}
}
