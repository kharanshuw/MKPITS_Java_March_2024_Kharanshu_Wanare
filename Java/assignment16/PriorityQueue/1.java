package practise;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import java.util.List;


public class Assignment {
	public List<Integer> sortBasedOnFreq(List<Integer> list) {
		HashMap<Integer, Integer> hashMap=new HashMap<Integer, Integer>();
		
		for (int i = 0; i < list.size(); i++) {
			hashMap.put(list.get(i), hashMap.getOrDefault(list.get(i),0)+1);
		}
		Collections.sort(list,(n1,n2)->
		{
			int freq1=hashMap.get(n1);
			int freq2=hashMap.get(n2);
			if (freq1 != freq2) {
				return freq2-freq1;
			}
			return n1-n2;
		}
		);
		
		return list;
		
		
	}
	
	public static void main(String[] args) {
		Assignment assignment=new Assignment();
		List<Integer> list=new ArrayList<Integer>();
		list.add(2);
		list.add(20);
		list.add(19);
		list.add(20);
		list.add(98);
		list.add(45);
		list.add(98);
		list.add(45);
		list.add(45);
		list=assignment.sortBasedOnFreq(list);
		System.out.println(list);
	}
}
