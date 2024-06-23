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
		arrayList.add("abcba");
		
	List<String> list	=arrayList.stream().filter(
				x->{
					StringBuilder stringBuilder=new StringBuilder(x);
				String string	=stringBuilder.reverse().toString();
					if (string.equals(x)) {
						return true;
					}
					else {
						return false;
					}
				}).collect(Collectors.toList());
	System.out.println(list);
	}
}
	
