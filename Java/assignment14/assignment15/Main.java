package assignment14.assignment15;

public class Main {
public static void main(String[] args) {
	Enrollment tracker=new Enrollment();
	tracker.add(new Course(192));
	tracker.add(new Course(87));
	tracker.add(new Course(55));
	tracker.add(new Course(141));
	tracker.add(new Course(217));
	
	tracker.display();
	
	tracker.check(87);
	
	tracker.remove(87);
	System.out.println("************");
	tracker.display();
}
}
