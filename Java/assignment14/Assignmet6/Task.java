package assignment14.Assignmet6;

public class Task {
	String taskidString;
	String tasknameString;
	String priorityString;
	String duedateString;
	public Task(String taskidString, String tasknameString, String priorityString, String duedateString) {
		super();
		this.taskidString = taskidString;
		this.tasknameString = tasknameString;
		this.priorityString = priorityString;
		this.duedateString = duedateString;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTaskidString() {
		return taskidString;
	}
	public void setTaskidString(String taskidString) {
		this.taskidString = taskidString;
	}
	public String getTasknameString() {
		return tasknameString;
	}
	public void setTasknameString(String tasknameString) {
		this.tasknameString = tasknameString;
	}
	public String getPriorityString() {
		return priorityString;
	}
	public void setPriorityString(String priorityString) {
		this.priorityString = priorityString;
	}
	public String getDuedateString() {
		return duedateString;
	}
	public void setDuedateString(String duedateString) {
		this.duedateString = duedateString;
	}
	@Override
	public String toString() {
		return "Task [taskidString=" + taskidString + ", tasknameString=" + tasknameString + ", priorityString="
				+ priorityString + ", duedateString=" + duedateString + "]";
	}
	
}