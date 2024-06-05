package streameapi;

public class Student {
	String nameString;
	int age;

	public Student(String nameString, int age) {
		super();
		this.nameString = nameString;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [nameString=" + nameString + ", age=" + age + "]";
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
