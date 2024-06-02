package practise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Assignment {
	HashMap<String,Employee> hashMap =new HashMap<String, Employee>();
	
	public void add(Employee employee) {
		if (employee.containsKey(employee.idString)) {
			System.out.println("employee alredy exist");
		      System.out.println( employee.idString + ":"+employee);
		      return;
		}
		else {
			hashMap.put(employee.idString, employee);
		}
		
	}
	
	public void update(Employee employee) {
		if (employee.containsKey(employee.idString)) {
			hashMap.put(employee.idString, employee);
		}
		else {
			System.out.println("not updated");
		}
	}
	
	public void delete(Employee employee) {
		if (employee.containsKey(employee.idString)) {
			hashMap.remove(employee.idString);
		}
		else {
			System.out.println("not exist");
		}
	}
	
	public void display() {
		for (Map.Entry<String, Employee> entry : hashMap.entrySet()) {
			String key = entry.getKey();
			Employee val = entry.getValue();
			System.out.println(key+":"+val);
		}
	}
}