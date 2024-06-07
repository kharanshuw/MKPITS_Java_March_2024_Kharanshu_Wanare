package assignment20;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment20 {	
	public static void main(String[] args) {
		
		ArrayList<String> arrayList=new ArrayList<String>();
		arrayList.add("commaSeparatedString");
		arrayList.add("bbbb");
		arrayList.add("argument");
		arrayList.add("zfg");
		arrayList.add("the");
		
		List<String> list=arrayList.stream().filter(
				x->{return x.length()>5;
				}).collect(Collectors.toList());
		
		System.out.println(list);
	}
}
