package practise;

import java.util.Map;
import java.util.TreeMap;

public class Assignment {
	TreeMap<String, String> contacts = new TreeMap<>();

	public void addcontact(String nameString, String phonenoString) {

		if (contacts.containsKey(nameString)) {
			System.out.println("Contact already exists");
		} else {

			contacts.put(nameString, phonenoString);

		}
	}
	
	public void updateContact(String nameString,String phonenoString) {
		
	    if (!contacts.containsKey(nameString)) {
	      System.out.println("Contact not found");
	    } else {
	      
	      contacts.put(nameString,phonenoString);
	     
	    }
	}
	
	public void deletecontact(String nameString) {
		boolean result=contacts.containsKey(nameString);
	    if (result==false) {
	      System.out.println("Contact not found");
	    } else {
	      contacts.remove(nameString);
	      System.out.println("Contact deleted successfully");
	    }
	}
	
	public void printContacts() {
		if (contacts.isEmpty()) {
		      System.out.println("Contact list is empty");
		    } else {
		     
		      for ( Map.Entry<String, String> entry : contacts.entrySet()) {
				String key = entry.getKey();
				String val = entry.getValue();
				System.out.println(key+":"+val);
			}
		    }
		  }
	}