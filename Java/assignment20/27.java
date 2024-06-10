package assignment20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Assignment20 {	
	public static void main(String[] args) {
		 List<String> list=new ArrayList<String>();  
		   
		 list.add("M");  
		 list.add("Apple");  
		 list.add("Banana");  
		 list.add("Grapes");  
		 Comparator<String> comparator=(a,b)->{
			int result=0;
			if (a.length()==b.length()) {
				result=0;
			}
			else if (a.length()>b.length()) {
				result=1;
			}
			else {
				result=-1;
			}
			return result;
		 };
		Optional<String> optional  =list.stream().min(comparator);
		
		if (optional.isPresent()) {
			System.out.println("result   :"+optional.get());
		}
		else {
			
			System.out.println("not found") ;
		}
	}
}
