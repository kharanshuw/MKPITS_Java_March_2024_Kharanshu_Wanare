package assignment20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



public class Assignment20 {	
	public static void main(String[] args) {
		ArrayList<String> arrayList=new ArrayList<String>();
				arrayList.add("abcdaaa");
				arrayList.add("avbfmcm");
				arrayList.add("cmdkf");
				arrayList.add("aaaaaaaaaaaa");
				
		Comparator<String> comparator=(x,y)->{
		return	Long.compare(x.chars().filter(ch->ch=='a'  || ch=='A').count(),
					y.chars().filter(ch->ch=='a' || ch=='A').count());
		};
		
		Optional<String> maxstringOptional=arrayList.stream().max(comparator);
		
		if (maxstringOptional.isPresent()) {
			System.out.println(maxstringOptional);
		}
		else {
			System.out.println("not present");
			
		}
	}
}
