package myproject;

public class AddressBook {
	String nameString;
	long phoneno;
	String emailString;

	public AddressBook() {
		nameString="pratik";
		phoneno=777777;
		emailString="abc@email.com";
	}
	public AddressBook(String nameString, long phoneno, String emailString) {
		super();
		this.nameString = nameString;
		this.phoneno = phoneno;
		this.emailString = emailString;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public String getEmailString() {
		return emailString;
	}
	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}	
}
package myproject;

import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		AddressBook arr[]=new AddressBook[3];
		Scanner scanner=new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			arr[i]=new AddressBook();
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("enter name ");
			String nameString=scanner.next();
			System.out.println("emter phone no");
			long phoneno=scanner.nextLong();
			System.out.println("enter email");
			String emailString=scanner.next();
			arr[i].setNameString(nameString);
			arr[i].setEmailString(emailString);
			arr[i].setPhoneno(phoneno);
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("details of all addressbook");
			System.out.println(arr[i].getEmailString());
			System.out.println(arr[i].getNameString());
			System.out.println(arr[i].getPhoneno());
		}
		
	}

}
