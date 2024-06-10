package assignment20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Assignment20 {	
	public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        
        numbers.stream().skip(1).forEach(
        		
        		x->{
        			System.out.println(x);
        		}
        		
        		);
        
        
		
		
	}
}
