package assignment20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.security.auth.x500.X500Principal;

public class Assignment20 {	
	public static void main(String[] args) {
		
		ArrayList<String> arrayList=new ArrayList<String>();
		arrayList.add("commaSeparatedString");
		arrayList.add("bbbb");
		arrayList.add("argument");
		arrayList.add("zfg");
		arrayList.add("the");
		
		Comparator<String> comparator=new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				if (o1.length()>o2.length()) {
					return 1;
				}
				else if (o1.length()==o2.length()) {
					return 0;
				}
				else {
					return -1;
				}
			}
		};
		
	Optional<String> optional=arrayList.stream().max(comparator);
				
		System.out.println(optional);
		
	}
}
