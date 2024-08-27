package myhashmap;

import java.util.HashMap;
import java.util.Map;

public class Myhashmap {
public static void main(String[] args) {
	HashMap<String, Integer> hashMap=new HashMap<String, Integer>();
	
	hashMap.put("pune", 12);
	hashMap.put("wardha",34);
	hashMap.put("amravti",27 );
	hashMap.put(null, 32);
	
	System.out.println(hashMap.keySet());
	System.out.println(hashMap.values());
	
	for (String string : hashMap.keySet()) {
		System.out.println(string);
	}
	
	for (Integer i : hashMap.values()) {
		System.out.println(i);
	}
	
	System.out.println(hashMap.entrySet());
	
	for (Map.Entry i : hashMap.entrySet()) {
		System.out.println(i);
	}
	
	System.out.println(hashMap.isEmpty());
	
	hashMap.remove(null);
	
	System.out.println(hashMap);
}
}
