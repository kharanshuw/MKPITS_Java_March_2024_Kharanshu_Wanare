package springproject6;


import java.util.HashMap;
import java.util.List;




public class Student {

	String nameString;

	String cityString;

	List<String> list;

	HashMap<String, String> educationDetailHashMap;

	
	
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



	public List<String> getList() {
		return list;
	}



	public void setList(List<String> list) {
		this.list = list;
	}



	public HashMap<String, String> getEducationDetailHashMap() {
		return educationDetailHashMap;
	}



	public void setEducationDetailHashMap(HashMap<String, String> educationDetailHashMap) {
		this.educationDetailHashMap = educationDetailHashMap;
	}



	@Override
	public String toString() {
		return "Student [nameString=" + nameString + ", cityString=" + cityString + ", list=" + list
				+ ", educationDetailHashMap=" + educationDetailHashMap + "]";
	}
	
	

}
