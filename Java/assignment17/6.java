package assignment17;

import java.util.HashMap;

public class Assignment {
	HashMap<String, Integer> hashMap=new HashMap<String, Integer>();
	public void addStudent(String keyString,Integer valueInteger) {
		hashMap.put(keyString, valueInteger);		
	}
	
	public void updateStudent(String keyString,Integer newvalueInteger) {
		if (hashMap.containsKey(keyString)) {
			hashMap.put(keyString, newvalueInteger);
		}
	}
	
	public void delete(String keyString) {
		Integer returnedvalue=null;
		if (hashMap.containsKey(keyString)) {
			 returnedvalue=hashMap.remove(keyString);
		}
		System.out.println(returnedvalue);
		
	}
	
	public void retrivevalue(String keyString) {
		Integer returnedvalue=null;
		if (hashMap.containsKey(keyString)) {
			 returnedvalue=hashMap.get(keyString);
		}
		System.out.println(returnedvalue);
	}
}
