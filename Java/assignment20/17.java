package assignment20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Assignment20 {	
	public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        //sorted((a, b) -> Integer.compare(b, a)) This part of the code utilizes the sorted method from the Stream API in Java to sort the elements in the stream. However, it also includes a custom comparator ((a, b) -> Integer.compare(b, a)) to achieve specific sorting behavior.
       numbers.stream().sorted((a,b)->Integer.compare(b, a)).skip(1).limit(1).forEach(x->{
    	   System.out.println(x);
       });
        
		
		
	}
}
