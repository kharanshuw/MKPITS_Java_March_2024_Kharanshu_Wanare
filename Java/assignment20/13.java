package assignment20;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Assignment20 {	
	public static void main(String[] args) {
		
		ArrayList<String> arrayList=new ArrayList<String>();
		arrayList.add("commaSeparatedString");
		arrayList.add("bbb");
		arrayList.add("argument");
		arrayList.add("zfg");
		arrayList.add("the");
		arrayList.add("cccccccccccccccccccc");
		arrayList.add("aaa");
		
		
		Map<Integer, List<String>>map=arrayList.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(map);	
	}
}
