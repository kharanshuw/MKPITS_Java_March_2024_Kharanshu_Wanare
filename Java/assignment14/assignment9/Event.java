package assignment14.assignment9;

public class Event {
	String evnetidString;
	String eventName;
	String location;
	String date;
	String time;
	public Event(String evnetidString, String eventName, String location, String date, String time) {
		super();
		this.evnetidString = evnetidString;
		this.eventName = eventName;
		this.location = location;
		this.date = date;
		this.time = time;
	}
	@Override
	public String toString() {
		return "Event [evnetidString=" + evnetidString + ", eventName=" + eventName + ", location=" + location
				+ ", date=" + date + ", time=" + time + "]";
	}
	public String getEvnetidString() {
		return evnetidString;
	}
	public void setEvnetidString(String evnetidString) {
		this.evnetidString = evnetidString;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
