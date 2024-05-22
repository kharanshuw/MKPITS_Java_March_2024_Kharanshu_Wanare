package assignment14.assignment9;

public class Main {
	public static void main(String[] args) {
		Event event=new Event("1", "a", "nagpur", "22-5-2024", "12.30");
		Event event2=new Event("2", "v", "mumbai", "22-5-2024", "12.30");
		Event event3=new Event("9", "q", "pune", "22-5-2024", "12.30");
		Event event4=new Event("3", "f", "kolhapur", "22-5-2024", "12.30");
		Event event5=new Event("10", "p", "amravti", "22-5-2024", "12.30");
		
		EventScheduling eventScheduling=new EventScheduling();
		eventScheduling.add(event5);
		eventScheduling.add(event4);
		eventScheduling.add(event3);
		eventScheduling.add(event2);
		eventScheduling.add(event);
		
		eventScheduling.display();
		
		eventScheduling.sort();
		System.out.println("******************************************");
		eventScheduling.display();
		System.out.println("******************************************");
		eventScheduling.details("p");
		System.out.println("******************************************");
		eventScheduling.removeById("p");
		
		
		
	}
}
