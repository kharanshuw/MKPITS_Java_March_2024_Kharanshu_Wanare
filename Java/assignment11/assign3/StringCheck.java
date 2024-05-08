package assignment11.assign3;

public class StringCheck {
	
	
	
	public void checkString (String string,String string2) throws StringMismatch {
		if (string.equals(string2)) {
			System.out.println("both strings are same");
		}
		else {
			StringMismatch stringMismatch=new StringMismatch();
			throw stringMismatch;
		}
	}
}
