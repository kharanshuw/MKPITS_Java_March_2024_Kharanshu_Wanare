package practise;

import java.util.TreeMap;

public class Assignment {
	TreeMap<String, Long> treeMap=new TreeMap<String, Long>();
	
	public void add(String nameString,Long populatationLong) {
		if (treeMap.containsKey(nameString)) {
			System.out.println("alredy exist");
		}
		else {
			treeMap.put(nameString, populatationLong);
		}
	}
	
	public void update(String nameString,Long populatationLong) {
		if (treeMap.containsKey(nameString)) {
			treeMap.put(nameString, populatationLong);
		}
		else {
			System.out.println("not exist");
		}
	}
	
	public void delete(String nameString) {
		if (treeMap.containsKey(nameString)) {
			treeMap.remove(nameString);
		}
		else {
			System.out.println("not exist");
		}
	}
	
	public void display(String nameString) {
		if (treeMap.containsKey(nameString)) {
			Long populationLong=treeMap.get(nameString);
			System.out.println(populationLong);
		}
		else {
			System.out.println("does not exist");
		}
	}
}