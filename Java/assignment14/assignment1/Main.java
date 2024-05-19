package studentManagementSystem;

public class Main {
	public static void main(String[] args) {
		StudentManagementSystem studentManagementSystem=new StudentManagementSystem();
		studentManagementSystem.addstudent(5, "pratik", "7.88");
		studentManagementSystem.removeById(5);
		studentManagementSystem.display();
	}
}
