package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Assignment {
	public static void main(String[] args) {
		List<String> myList = Arrays.asList("apple","apple", "banana", "banana","banana","grape", "longword", "elephant","elephant","elephant","elephant");
		
	Map<String, Long> map=		myList.stream().collect(Collectors.groupingBy(
			x->x.toString(),Collectors.counting()));
	System.out.println(map);
	}
}
	
	