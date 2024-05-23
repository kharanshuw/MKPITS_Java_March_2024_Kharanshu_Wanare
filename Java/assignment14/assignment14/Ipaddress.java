package assignment14.assignment14;

public class Ipaddress {
	String ipaddressString;

	public Ipaddress(String ipaddressString) {
		super();
		this.ipaddressString = ipaddressString;
	}

	public String getIpaddressString() {
		return ipaddressString;
	}

	public void setIpaddressString(String ipaddressString) {
		this.ipaddressString = ipaddressString;
	}

	@Override
	public String toString() {
		return "Ipaddress [ipaddressString=" + ipaddressString + "]";
	}
	
	
}
