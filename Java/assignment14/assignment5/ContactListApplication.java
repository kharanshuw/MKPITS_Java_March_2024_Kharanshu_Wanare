package contactListApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class ContactListApplication {

	private	ArrayList<Contact> arrayList;

	public ContactListApplication() {
		super();
		this.arrayList =new ArrayList<Contact>();
	}
		

		public void addcontact(Contact contact) {
			arrayList.add(contact);
		}
		
		public void removeById(int id) {
			Iterator<Contact> iterator =arrayList.iterator();
			while (iterator.hasNext()) {
				Contact contact = (Contact) iterator.next();
				if (contact.getContactid()==id) {
					iterator.remove();
					System.out.println("contact detail deleted");
				}
			}
		}
		
		public void searchById(int id) {
			Iterator<Contact> iterator =arrayList.iterator();
			while (iterator.hasNext()) {
				Contact contact = (Contact) iterator.next();
				if (contact.getContactid()==id) {
					System.out.println("student detail "+contact.toString());
				}
			}
		}
		public void display() {
			Iterator<Contact> iterator =arrayList.iterator();
			while (iterator.hasNext()) {
				Contact contact = (Contact) iterator.next();
				System.out.println("student detail "+contact);
				
			}
			
		}
		
		public void displaybysort() {
			Collections.sort(arrayList);
			this.display();
		}
}
