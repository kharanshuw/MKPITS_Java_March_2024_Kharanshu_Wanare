package assignment11.assign3;

public class TestStringMismatch {
	public static void main(String[] args) {
		StringCheck stringCheck = new StringCheck();
		try {
			stringCheck.checkString("shreyash", "utkarsh");
		} 
		catch (StringMismatch e) {
			
			e.printStackTrace();
		}
	}
}
