package assignment11.assing2;

public class Car {
	private String nameString;
	
	
	
	public Car(String nameString) {
		super();
		this.nameString = nameString;
	}



	public String getNameString() {
		return nameString;
	}



	public void setNameString(String nameString) {
		this.nameString = nameString;
	}



	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}



	public void display() {
		System.out.println("name of car is "+nameString);
	}
}
