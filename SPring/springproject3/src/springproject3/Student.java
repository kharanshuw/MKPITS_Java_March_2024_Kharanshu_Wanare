package springproject3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
	@Value("pratik")
	String nameString;
	
	@Value("nagpur")
	String cityString;

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getCityString() {
		return cityString;
	}

	public void setCityString(String cityString) {
		this.cityString = cityString;
	}

	@Override
	public String toString() {
		return "Student [nameString=" + nameString + ", cityString=" + cityString + "]";
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
