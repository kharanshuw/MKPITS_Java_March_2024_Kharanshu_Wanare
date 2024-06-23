package practise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Assignment {
	public static void main(String[] args) {
		ArrayList<String> arrayList=new ArrayList<String>();
		
		arrayList.add("Concatenate");
		arrayList.add("list");
		arrayList.add("strings");
		
	List<Character> list	=arrayList.stream().map(
				x->{
					return x.charAt(0);
				}
				).collect(Collectors.toList());
	System.out.println(list);
	}
}
	
	