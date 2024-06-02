package practise;

import java.util.LinkedHashMap;
import java.util.Map;
public class Assignment {
	LinkedHashMap<String, Integer> linkedHashMap=new LinkedHashMap<String, Integer>();
	
	public void add(String nameString,Integer noInteger) {
		if (linkedHashMap.containsKey(nameString)) {
			System.out.println("product exitst");
		}
		else {
			linkedHashMap.put(nameString, noInteger);
		}
	}
	
	public void update(String nameString,Integer noInteger) {
		if (linkedHashMap.containsKey(nameString)) {
			linkedHashMap.put(nameString, noInteger);
		}
		else {
			System.out.println("does not exist");
			
		}
	}
	
	public void delete(String nameString) {
		if (linkedHashMap.containsKey(nameString)) {
			linkedHashMap.remove(nameString);
		}
		else {
			System.out.println("does not exist");
			
		}
	}
	
	public void display() {
		for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key+":"+val);
		}
	}
}