package assignment14.assignment14;

import java.util.HashSet;
import java.util.Iterator;

public class Tracker {
	HashSet<Ipaddress> hashSet=new HashSet<Ipaddress>();
	
	public void add(Ipaddress ipaddress) {
		hashSet.add(ipaddress);
	}
	
	public void check(String ipaddressString) {
		Iterator<Ipaddress> iterator=hashSet.iterator();
		boolean flag=false;
		while (iterator.hasNext()) {
			Ipaddress ipaddress = (Ipaddress) iterator.next();
			if (ipaddress.getIpaddressString().equals(ipaddressString)) {
				System.out.println("you have visited before");
				flag=true;
			}
		}
		if (flag==false) {
			System.out.println("you have not visited before");
		}
		
	}
	
	public void remove(String ipaddressString) {
		Iterator<Ipaddress> iterator=hashSet.iterator();
		boolean flag=false;
		while (iterator.hasNext()) {
			Ipaddress ipaddress = (Ipaddress) iterator.next();
			if (ipaddress.getIpaddressString().equals(ipaddressString)) {
				iterator.remove();
			}
		}
		
		
	}
	
	public void display() {
		Iterator<Ipaddress> iterator=hashSet.iterator();
		
		while (iterator.hasNext()) {
			Ipaddress ipaddress = (Ipaddress) iterator.next();
			System.out.println(ipaddress);
		}
	}
	
	
}
