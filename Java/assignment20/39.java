package practise;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Assignment {
	public static void main(String[] args) {
		 List<String> myList = Arrays.asList("apple", "apple", "banana", "banana",
			        "banana", "grape", "longword", "elephant", "elephant", "elephant", "elephant");
		
		double sizeoflist  =myList.size();
		
		double sumoflist=myList.stream().mapToDouble(String::length).sum();
		
		double avg=sumoflist/sizeoflist;
		
		System.out.println(avg);
	}
}
	
	