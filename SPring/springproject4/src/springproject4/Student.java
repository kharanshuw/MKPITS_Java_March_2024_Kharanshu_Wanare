package springproject4;

public class Student {
	
	String nameString;
	
	String cityString;

	public Student(String nameString, String cityString) {
		super();
		this.nameString = nameString;
		this.cityString = cityString;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [nameString=" + nameString + ", cityString=" + cityString + "]";
	}
	
	
	
	

}