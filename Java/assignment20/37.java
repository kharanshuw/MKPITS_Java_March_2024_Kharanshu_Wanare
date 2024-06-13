package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Assignment {
	public static void main(String[] args) {
		List<String> myList = Arrays.asList("apple", "banana", "grape", "longword", "elephant");
		
	long countno =myList.stream().filter(
			(x)->{
				x=x.toLowerCase();
				return x.contains("e");	
			}
			).count();
	
	System.out.println(countno);
	}
}
	
	