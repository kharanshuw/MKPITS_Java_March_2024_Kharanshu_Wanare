package springproject5;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.transform.Source;

public class Student {
	
	String nameString;
	
	String cityString;
	
	Address address;
	
	List<String> list;
	
	HashMap<String, String> educationDetailHashMap;
	
	
	public Student(String nameString, String cityString, Address address, List<String> list,HashMap<String, String> hashMap) {
		super();
		this.nameString = nameString;
		this.cityString = cityString;
		this.address = address;
		this.list=list;
		this.educationDetailHashMap=hashMap;
	}


	@Override
	public String toString() {
		return "Student [nameString=" + nameString + ", cityString=" + cityString + ", address=" + address + ", list="
				+ list + ", educationDetailHashMap=" + educationDetailHashMap + "]";
	}

	public void printmap() {
	Iterator<java.util.Map.Entry<String, String>> iterator	=educationDetailHashMap.entrySet().iterator();
	
	while (iterator.hasNext()) {
		Map.Entry<java.lang.String, java.lang.String> entry = (Map.Entry<java.lang.String, java.lang.String>) iterator
				.next();
		
		System.out.println(entry.getKey());
		System.out.println(entry.getValue());
	}
	}
	
	
	}
	

