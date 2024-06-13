package practise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Assignment {
	public static void main(String[] args) {
		List<String> myList = Arrays.asList("apple", "banana", "grape", "longword");
		/*
		 * .sorted(Comparator.reverseOrder()): This part sorts the elements in the stream in 			reverse order.

			sorted: This method sorts the stream according to a provided comparator.
			Comparator.reverseOrder(): This is a predefined comparator that reverses the 				natural	ordering of elements.
		 */
	 List<String> list	=myList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	 
	 System.out.println(list);
	}
}
	
	