package assignment14.assignment14;

public class Main {
	public static void main(String[] args) {
		Tracker tracker=new Tracker();
		tracker.add(new Ipaddress("192.1.11"));
		tracker.add(new Ipaddress("87.103.241.203"));
		tracker.add(new Ipaddress("55.113.181.56"));
		tracker.add(new Ipaddress("141.26.150.149"));
		tracker.add(new Ipaddress("217.171.212.173"));
		
		tracker.display();
		
		tracker.check("87.103.241.203");
		
		tracker.remove("87.103.241.203");
		System.out.println("************");
		tracker.display();
	}
}
