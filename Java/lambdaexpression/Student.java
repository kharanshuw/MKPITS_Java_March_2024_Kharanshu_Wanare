package lambdaexpression;

public class Student {

	  // Private attributes to encapsulate data
	  private String name;
	  private int id;

	  // Default constructor
	  public Student() {
	    this.name = "";
	    this.id = 0;
	    System.out.println("this is default constructor");
	  }

	  // Parameterized constructor to initialize with values
	  public Student(String name, int id) {
	    this.name = name;
	    this.id = id;
	  }

	  // Getter methods to access private attributes
	  public String getName() {
	    return name;
	  }

	  public int getId() {
	    return id;
	  }

	  // Setter methods to modify private attributes (optional)
	  public void setName(String name) {
	    this.name = name;
	  }

	  public void setId(int id) {
	    this.id = id;
	  }

	  // Method to display student information
	  public void displayDetails() {
	    System.out.println("Name: " + name);
	    System.out.println("ID: " + id);
	  }
	  
	  public  void disp(String nameString) {
		  System.out.println("this is static method"+nameString);
	  }

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + "]";
	}
	  
	  

	  
	  
	}
