package mylinkedhashmap;

import java.util.LinkedHashMap;

public class MyLinkedHashMap {
public static void main(String[] args) {
	LinkedHashMap<String,Integer> linkedHashMap=new LinkedHashMap<String, Integer>();
	linkedHashMap.put("nagpur", 1);
	linkedHashMap.put("a", 1+1);
	linkedHashMap.put("b", 1+2);
	linkedHashMap.put("c", 1+3);
	linkedHashMap.put("d", 1+4);
	linkedHashMap.put("e", 1+5);
	
	System.out.println(linkedHashMap);
	System.out.println(linkedHashMap.containsKey("a"));
	System.out.println(linkedHashMap.containsKey(linkedHashMap));
	
	/*for (String i : linkedHashMap.keySet()) {
		System.out.println(i);
		System.out.println(i.hashCode());
	}*/
	
	 
}
}
