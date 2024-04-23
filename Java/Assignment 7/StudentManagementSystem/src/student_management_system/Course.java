package student_management_system;

public class Course {
	String cnameString;
	String instructorString;
	String scheduleString;
	public Course(String cnameString, String instructorString, String scheduleString) {
		super();
		this.cnameString = cnameString;
		this.instructorString = instructorString;
		this.scheduleString = scheduleString;
	}
	public String getCnameString() {
		return cnameString;
	}
	public void setCnameString(String cnameString) {
		this.cnameString = cnameString;
	}
	public String getInstructorString() {
		return instructorString;
	}
	public void setInstructorString(String instructorString) {
		this.instructorString = instructorString;
	}
	public String getScheduleString() {
		return scheduleString;
	}
	public void setScheduleString(String scheduleString) {
		this.scheduleString = scheduleString;
	}
	
	
}
