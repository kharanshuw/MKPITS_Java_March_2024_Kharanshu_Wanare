package assignment14.assignment15;

public class Course {
	long coursecode;

	public Course(long coursecode) {
		super();
		this.coursecode = coursecode;
	}

	@Override
	public String toString() {
		return "Course [coursecode=" + coursecode + "]";
	}

	public long getCoursecode() {
		return coursecode;
	}

	public void setCoursecode(long coursecode) {
		this.coursecode = coursecode;
	}
	
	
}
