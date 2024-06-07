package assignment20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Assignment20 {	
	public static void main(String[] args) {
        List<String> numbers = List.of("s","a","c","d","");
        boolean allNonEmpty = numbers.stream()
        		// The result of the allMatch operation is stored in the allNonEmpty variable. It will be true if all strings in the list are non-empty, and false otherwise.
        		  .allMatch(str -> !str.isEmpty());

        
        System.out.println(allNonEmpty);
	}
}
