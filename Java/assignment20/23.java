package assignment20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Assignment20 {	
	public static void main(String[] args) {
		 List<Integer> list = new ArrayList<Integer>(); 
	        list.add(1); 
	        list.add(3); 
	        list.add(7);
	        list.add(4);
	        TestClass testClass=new TestClass();
	        
     int[] arr = list.stream().mapToInt(testClass::getint).toArray();
     
     for (int i : arr) {
		System.out.println(i);
	}
	}
}
