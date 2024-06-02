package practise;

import java.util.TreeMap;

public class Assignment {
	TreeMap<String, String> treeMap=new TreeMap<String, String>();
	
	public void add(String wordString,String meaningString) {
		if (treeMap.containsKey(wordString)) {
			System.out.println("word already exists");
		} else {

			treeMap.put( wordString	, meaningString);

		}
	}	
	
	public void update(String wordString,String meaningString) {
		if (treeMap.containsKey(wordString)) {
			System.out.println("word already exists");
		} else {

			treeMap.put( wordString	, meaningString);

		}
	}
	
	public void delete(String wordString) {
		if (treeMap.containsKey(wordString)) {
			System.out.println("word already exists");
		} else {

			treeMap.remove(wordString);

		}
	}
	
	public void retrive(String wordString) {
		if (treeMap.containsKey(wordString)) {
			
			treeMap.get(wordString);
		}
	}
}