package assignment20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Assignment20 {	
	public static void main(String[] args) {
		
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(5);
		arrayList.add(5);
		arrayList.add(5);
		arrayList.add(5);
	
		int product=arrayList.stream()
				.mapToInt(Integer::intValue)
				.reduce(1,(n,n1)->{
			return n*n1;
		});
		
System.out.println(product);
	}
}
