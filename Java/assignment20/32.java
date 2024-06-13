package practise;



import java.util.Arrays;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Assignment {
	public static void main(String[] args) {
		List<String> myList = Arrays.asList("apple", "banana", "grape", "longword");
	
	int totalsum	=myList.stream().mapToInt(String::length).sum();
System.out.println(totalsum);
/*		
 * this is another way to print string sum length
System.out.println((myList.stream().map(
			 t -> {
				return t.length();
			 }
			 ).reduce(
					 0,(t1,t2)->
					 {
						return t1+t2;
					 }
					 )));
					 */
	
	}
}
	
	